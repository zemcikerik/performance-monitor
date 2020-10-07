package sk.zemco.performancemonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.zemco.performancemonitor.dto.BasicInfoDto;
import sk.zemco.performancemonitor.dto.UsageInfoDto;
import sk.zemco.performancemonitor.service.BasicInfoService;
import sk.zemco.performancemonitor.service.UsageInfoService;

import java.util.List;

@RestController
@EnableScheduling
@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PerformanceMonitorApplication {

    private final BasicInfoService basicInfoService;
    private final UsageInfoService usageInfoService;

    public PerformanceMonitorApplication(BasicInfoService basicInfoService, UsageInfoService usageInfoService) {
        this.basicInfoService = basicInfoService;
        this.usageInfoService = usageInfoService;
    }

    @GetMapping("info")
    public BasicInfoDto info() {
        return basicInfoService.getBasicInfo();
    }

    @GetMapping("usage")
    public List<UsageInfoDto> usage() {
        return usageInfoService.getUsageInfo();
    }

    @Scheduled(fixedRate = 2000)
    public void updateInfo() {
        usageInfoService.updateInfo();
    }

    public static void main(String[] args) {
        SpringApplication.run(PerformanceMonitorApplication.class, args);
    }

}
