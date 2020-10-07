package sk.zemco.performancemonitor.dto;

public class UsageInfoDto {

    private final long unixTimestamp;
    private final double cpuUsage;

    public UsageInfoDto(long unixTimestamp, double cpuUsage) {
        this.unixTimestamp = unixTimestamp;
        this.cpuUsage = cpuUsage;
    }

    public long getUnixTimestamp() {
        return unixTimestamp;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

}
