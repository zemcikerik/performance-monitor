export interface BasicInfo {
    computerName: string;
    osName: string;
    osVersion: OSVersion;
}

export interface OSVersion {
    version: string;
    codeName: string;
    buildNumber: string;
}

export interface UsageInfo {
    unixTimestamp: number;
    cpuUsage: number;
}