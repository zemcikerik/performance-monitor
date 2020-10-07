package sk.zemco.performancemonitor.service;

import sk.zemco.performancemonitor.dto.UsageInfoDto;

import java.util.List;

public interface UsageInfoService {

    List<UsageInfoDto> getUsageInfo();
    void updateInfo();

}
