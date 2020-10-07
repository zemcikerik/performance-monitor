package sk.zemco.performancemonitor.dto;

public class OSVersionDto {

    private final String version;
    private final String codeName;
    private final String buildNumber;

    public OSVersionDto(String version, String codeName, String buildNumber) {
        this.version = version;
        this.codeName = codeName;
        this.buildNumber = buildNumber;
    }

    public String getVersion() {
        return version;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

}
