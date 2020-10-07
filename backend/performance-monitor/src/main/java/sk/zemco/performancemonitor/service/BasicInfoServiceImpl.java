package sk.zemco.performancemonitor.service;

import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;
import sk.zemco.performancemonitor.dto.BasicInfoDto;
import sk.zemco.performancemonitor.dto.OSVersionDto;

import java.util.Map;

@Service
public class BasicInfoServiceImpl implements BasicInfoService {

    @Override
    public BasicInfoDto getBasicInfo() {
        SystemInfo info = new SystemInfo();
        OperatingSystem os = info.getOperatingSystem();

        OSVersionDto osVersionDto = createOsVersionDto(os);
        return new BasicInfoDto(getComputerName(), System.getProperty("os.name"), osVersionDto);
    }

    private static OSVersionDto createOsVersionDto(OperatingSystem os) {
        OperatingSystem.OSVersionInfo info = os.getVersionInfo();
        return new OSVersionDto(info.getVersion(), info.getCodeName(), info.getBuildNumber());
    }

    private static String getComputerName() {
        Map<String, String> env = System.getenv();

        if (env.containsKey("COMPUTERNAME")) {
            return env.get("COMPUTERNAME");
        }
        if (env.containsKey("HOSTNAME")) {
            return env.get("HOSTNAME");
        }
        return null;
    }

}
