package com.gdh.assetMenagement.config;

import com.gdh.assetMenagement.dto.common.CodeDto;
import com.gdh.assetMenagement.dto.common.CommonComponent;
import com.gdh.assetMenagement.dto.rDto.*;
import com.gdh.assetMenagement.service.rService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Component
public class RunConfig implements CommandLineRunner {

    private CommonComponent commonComponent;
    private CodeRService codeRService;
    private LogiCodeRService logiCodeRService;
    private BizzCodeRService bizzCodeRService;
    private UkcdCodeRService ukcdCodeRService;
    private StckCodeRService stckCodeRService;
    private final Lock lock = new ReentrantLock();

    @Autowired
    public RunConfig(CommonComponent commonComponent, CodeRService codeRService, LogiCodeRService logiCodeRService, BizzCodeRService bizzCodeRService, UkcdCodeRService ukcdCodeRService, StckCodeRService stckCodeRService) {
        this.commonComponent = commonComponent;
        this.codeRService = codeRService;
        this.logiCodeRService = logiCodeRService;
        this.bizzCodeRService = bizzCodeRService;
        this.ukcdCodeRService = ukcdCodeRService;
        this.stckCodeRService = stckCodeRService;
    }

    @Override
    public void run(String... args) throws Exception{
        updateCodeList();
    }

    private void updateCodeList() {
        lock.lock();
        try {
            LinkedList<CodeDto> codeList = new LinkedList<>();

            addCodeList(codeList);
            addLogiCodeList(codeList);
            addBizzCodeList(codeList);
            addUkcdCodeList(codeList);
            addStckCodeList(codeList);

            commonComponent.setCodeList(codeList);
        } finally {
            lock.unlock();
        }
    }

    private void addStckCodeList(LinkedList<CodeDto> codeList){
        List<StckCodeRDto> stckCodeRDtoList = stckCodeRService.selectStckCodeFindAll().stream()
             .filter(dto -> dto.getUse() == true)
             .filter(dto -> dto.getDel() == false)
             .collect(Collectors.toList());
        stckCodeRDtoList.forEach(stckCodeRdto -> {
            CodeDto codeDto = new CodeDto();
            codeDto.setCode(stckCodeRdto.getCode());
            codeDto.setCodeValue(stckCodeRdto.getCodeValue());
            codeDto.setFullCode(stckCodeRdto.getFullCode());
            codeDto.setParentsCode(stckCodeRdto.getParentsCode());
            codeList.add(codeDto);
        });
    }

    private void addUkcdCodeList(LinkedList<CodeDto> codeList){
        List<UkcdCodeRDto> ukcdCodeRDtoList = ukcdCodeRService.selectUkcdCodeFindAll();
        ukcdCodeRDtoList = ukcdCodeRDtoList.stream()
             .filter(dto -> dto.getUse() == true)
             .filter(dto -> dto.getDel() == false)
             .collect(Collectors.toList());
        ukcdCodeRDtoList.forEach(ukcdCodeRdto -> {
            CodeDto codeDto = new CodeDto();
            codeDto.setCode(ukcdCodeRdto.getCode());
            codeDto.setCodeValue(ukcdCodeRdto.getCodeValue());
            codeDto.setFullCode(ukcdCodeRdto.getFullCode());
            codeDto.setParentsCode(ukcdCodeRdto.getParentsCode());
            codeList.add(codeDto);
        });
    }

    private void addBizzCodeList(LinkedList<CodeDto> codeList) {
        List<BizzCodeRDto> bizzCodeRDtoList = bizzCodeRService.selectBizzCodeFindAll().stream()
               .filter(dto -> dto.getUse() == true)
               .filter(dto -> dto.getDel() == false)
               .collect(Collectors.toList());
        bizzCodeRDtoList.forEach(bizzCodeRdto -> {
            CodeDto codeDto = new CodeDto();
            codeDto.setCode(bizzCodeRdto.getCode());
            codeDto.setCodeValue(bizzCodeRdto.getCodeValue());
            codeDto.setFullCode(bizzCodeRdto.getFullCode());
            codeDto.setParentsCode(bizzCodeRdto.getParentsCode());
            codeList.add(codeDto);
        });
    }

    private void addLogiCodeList(LinkedList<CodeDto> codeList) {
        List<LogiCodeRDto> logiCodeRDtoList = logiCodeRService.selectLogiCodeFindAll().stream()
                .filter(dto -> dto.getUse() == true)
                .filter(dto -> dto.getDel() == false)
                .collect(Collectors.toList());
        logiCodeRDtoList.forEach(logiCodeRdto -> {
            CodeDto codeDto = new CodeDto();
            codeDto.setCode(logiCodeRdto.getCode());
            codeDto.setCodeValue(logiCodeRdto.getCodeValue());
            codeDto.setFullCode(logiCodeRdto.getFullCode());
            codeDto.setParentsCode(logiCodeRdto.getParentsCode());
            codeList.add(codeDto);
        });
    }

    private void addCodeList(LinkedList<CodeDto> codeList){
        List<CodeRDto> codeRDtoList = codeRService.selectCodeFindAll().stream()
                .filter(dto -> dto.getUse() == true)
                .filter(dto -> dto.getDel() == false)
                .collect(Collectors.toList());
        codeRDtoList.forEach(codeRDto -> {
            CodeDto codeDto = new CodeDto();
            codeDto.setCode(codeRDto.getCode());
            codeDto.setCodeValue(codeRDto.getCodeValue());
            codeList.add(codeDto);
        });
    }

}