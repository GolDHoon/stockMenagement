package com.gdh.assetMenagement.schedule.stock.kis;

import com.gdh.assetMenagement.dto.common.CommonComponent;
import com.gdh.assetMenagement.dto.common.KisCertificationDto;
import com.gdh.assetMenagement.dto.rDto.KisCertificationRDto;
import com.gdh.assetMenagement.dto.rDto.KisInfoRDto;
import com.gdh.assetMenagement.service.api.kis.KisCertificationService;
import com.gdh.assetMenagement.service.rService.KisCertificationRService;
import com.gdh.assetMenagement.service.rService.KisInfoRService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KisReCertificationJob implements Job {

    private CommonComponent commonComponent;
    private KisInfoRService kisInfoRService;
    private KisCertificationRService kisCertificationRService;
    private KisCertificationService kisCertificationService;

    public KisReCertificationJob(CommonComponent commonComponent, KisInfoRService kisInfoRService, KisCertificationRService kisCertificationRService, KisCertificationService kisCertificationService) {
        this.commonComponent = commonComponent;
        this.kisInfoRService = kisInfoRService;
        this.kisCertificationRService = kisCertificationRService;
        this.kisCertificationService = kisCertificationService;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        /*kisInfo 전체조회*/
        List<KisInfoRDto> kisInfoRDtos = kisInfoRService.selectKisInfoFindAll().stream()
                .filter(dto -> dto.getUse() == true)
                .filter(dto -> dto.getDel() == false)
                .collect(Collectors.toList());

        kisInfoRDtos.forEach(dto -> {
            KisCertificationRDto kisCertificationRDto = kisCertificationRService.selectKisCertificationFindByKisInfoId(dto.getId());
            if(kisCertificationRDto != null){
                String appKey = kisCertificationRDto.getAppKey();
                String appSecret = kisCertificationRDto.getAppSecret();
                String approvalKey = kisCertificationRDto.getApprovalKey();
                Instant accessTokenExpired = kisCertificationRDto.getAccessTokenExpired();

                try {
                    approvalKey = kisCertificationService.receiveWebSocketAccessKey(appKey, appSecret);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                Map<String, String> accessTokenMap = null;

                if(accessTokenExpired != null){
                    Instant hourBeforeAccessTokenExpired = accessTokenExpired.minus(Duration.ofHours(1));
                    Instant now = Instant.now();

                    if (hourBeforeAccessTokenExpired.isAfter(now)) {
                        try {
                            accessTokenMap = kisCertificationService.receiveAccessToken(appKey, appSecret);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }else{
                    try {
                        accessTokenMap = kisCertificationService.receiveAccessToken(appKey, appSecret);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

                KisCertificationDto kisCertificationDto = commonComponent.getKisCertificationDtoMap().get(dto.getUserIdx());

                if(kisCertificationDto != null) {
                    kisCertificationDto = new KisCertificationDto();
                }

                kisCertificationRDto.setApprovalKey(approvalKey);

                if(accessTokenMap != null) {
                    String accessToken = accessTokenMap.get("accessToken");
                    String tokenType = accessTokenMap.get("tokenType");
                    accessTokenExpired = Instant.parse(accessTokenMap.get("accessTokenExpired"));

                    kisCertificationRDto.setAccessToken(accessToken);
                    kisCertificationRDto.setTokenType(tokenType);
                    kisCertificationRDto.setAccessTokenExpired(accessTokenExpired);

                    kisCertificationDto.setAccessToken(accessToken);
                    kisCertificationDto.setTokenType(tokenType);
                    kisCertificationDto.setAccessTokenExpired(accessTokenExpired);
                }else{
                    kisCertificationDto.setAccessToken(kisCertificationRDto.getAccessToken());
                    kisCertificationDto.setTokenType(kisCertificationRDto.getTokenType());
                    kisCertificationDto.setAccessTokenExpired(kisCertificationRDto.getAccessTokenExpired());
                }

                kisCertificationRService.saveKisCertification(kisCertificationRDto);

                kisCertificationDto.setUserIdx(dto.getUserIdx());
                kisCertificationDto.setApprovalKey(approvalKey);

                Map<String, KisCertificationDto> kisCertificationDtoMap = commonComponent.getKisCertificationDtoMap();
                kisCertificationDtoMap.put(kisCertificationDto.getUserIdx(), kisCertificationDto);
            }
        });
    }
}