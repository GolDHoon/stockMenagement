package com.gdh.assetMenagement.schedule.stock.kis;

import com.gdh.assetMenagement.dto.common.CodeDto;
import com.gdh.assetMenagement.dto.common.CommonComponent;
import com.gdh.assetMenagement.dto.rDto.KisCertificationRDto;
import com.gdh.assetMenagement.dto.rDto.KisInfoRDto;
import com.gdh.assetMenagement.service.rService.KisCertificationRService;
import com.gdh.assetMenagement.service.rService.KisInfoRService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class KisReCertificationJob implements Job {

    private CommonComponent commonComponent;
    private KisInfoRService kisInfoRService;
    private KisCertificationRService kisCertificationRService;

    public KisReCertificationJob(CommonComponent commonComponent, KisInfoRService kisInfoRService, KisCertificationRService kisCertificationRService) {
        this.commonComponent = commonComponent;
        this.kisInfoRService = kisInfoRService;
        this.kisCertificationRService = kisCertificationRService;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        List<KisInfoRDto> kisInfoRDtos = kisInfoRService.selectKisInfoFindAll().stream()
                .filter(dto -> dto.getUse() == true)
                .filter(dto -> dto.getDel() == false)
                .collect(Collectors.toList());

        kisInfoRDtos.forEach(dto -> {
            KisCertificationRDto kisCertificationRDto = kisCertificationRService.selectKisCertificationFindByKisInfoId(dto.getId());
            if(kisCertificationRDto != null){
                String appKey = kisCertificationRDto.getAppKey();
                String appSecret = kisCertificationRDto.getAppSecret();

            }

        });

        LinkedList<CodeDto> codeList = commonComponent.getCodeList();
        System.out.println("Job 테스트!");
    }
}