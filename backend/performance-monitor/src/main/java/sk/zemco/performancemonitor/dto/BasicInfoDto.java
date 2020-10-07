package sk.zemco.performancemonitor.dto;

public class BasicInfoDto {

    private final String computerName;
    private final String osName;
    private final OSVersionDto osVersion;

    public BasicInfoDto(String computerName, String osName, OSVersionDto osVersion) {
        this.computerName = computerName;
        this.osName = osName;
        this.osVersion = osVersion;
    }

    public String getComputerName() {
        return computerName;
    }

    public String getOsName() {
        return osName;
    }

    public OSVersionDto getOsVersion() {
        return osVersion;
    }

}
