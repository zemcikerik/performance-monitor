package sk.zemco.performancemonitor.service;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;
import sk.zemco.performancemonitor.dto.UsageInfoDto;

import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class UsageInfoServiceImpl implements UsageInfoService {

    private static final int MAX_ELEMENTS = 60;

    private final OperatingSystemMXBean operatingSystemMXBean;
    private final LinkedList<UsageInfoDto> usageList;

    public UsageInfoServiceImpl() {
        // IoC failed
        this.operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        this.usageList = new LinkedList<>();
    }

    @Override
    public List<UsageInfoDto> getUsageInfo() {
        return new ArrayList<>(usageList);
    }

    @Override
    public void updateInfo() {
        usageList.add(createUsageInfo());

        if (usageList.size() > MAX_ELEMENTS) {
            usageList.removeFirst();
        }
    }

    private UsageInfoDto createUsageInfo() {
        long unixTimestamp = Instant.now().getEpochSecond();
        double averageUsage = operatingSystemMXBean.getCpuLoad() * 100;

        return new UsageInfoDto(unixTimestamp, averageUsage);
    }

}
