package com.gdh.assetMenagement.config;

import com.gdh.assetMenagement.dto.common.CodeDto;
import com.gdh.assetMenagement.dto.common.CommonComponent;
import com.gdh.assetMenagement.entity.*;
import com.gdh.assetMenagement.repository.KisCodeRepository;
import com.gdh.assetMenagement.repository.basic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class RunConfig implements CommandLineRunner {

    private final CommonComponent commonComponent;
    private final CodeRepository codeRepository;
    private final LogiCodeRepository logiCodeRepository;
    private final BizzCodeRepository bizzCodeRepository;
    private final UkcdCodeRepository ukcdCodeRepository;
    private final StckCodeRepository stckCodeRepository;
    private final KisCodeRepository kisCodeRepository;

    private final Lock lock = new ReentrantLock();

    @Autowired
    public RunConfig(CommonComponent commonComponent
            , CodeRepository codeRepository
            , LogiCodeRepository logiCodeRepository
            , UkcdCodeRepository ukcdCodeRepository
            , BizzCodeRepository bizzCodeRepository
            , StckCodeRepository stckCodeRepository
            , KisCodeRepository kisCodeRepository) {
        this.commonComponent = commonComponent;
        this.codeRepository = codeRepository;
        this.logiCodeRepository = logiCodeRepository;
        this.ukcdCodeRepository = ukcdCodeRepository;
        this.bizzCodeRepository = bizzCodeRepository;
        this.stckCodeRepository = stckCodeRepository;
        this.kisCodeRepository = kisCodeRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        updateCodeList();
    }

    private void updateCodeList() {
        LinkedList<CodeDto> codeList = new LinkedList<>();

        codeRepository.findAll().forEach(entity -> addCodeToList(entity, codeList));
        logiCodeRepository.findAll().forEach(entity -> addLogiCodeToList(entity, codeList));
        bizzCodeRepository.findAll().forEach(entity -> addBizzCodeToList(entity, codeList));
        ukcdCodeRepository.findAll().forEach(entity -> addUkcdCodeToList(entity, codeList));
        stckCodeRepository.findAll().forEach(entity -> addStckCodeToList(entity, codeList));
        kisCodeRepository.findAll().forEach(entity -> addKisCodeToList(entity, codeList));

        lock.lock();
        try {
            commonComponent.setCodeList(codeList);
        } finally {
            lock.unlock();
        }
    }

    private void addCodeToList(Code entity, LinkedList<CodeDto> codeList) {
        CodeDto codeDto = new CodeDto();
        codeDto.setCode(entity.getCode());
        codeDto.setCodeValue(entity.getCodeValue());
        codeDto.setFullCode(entity.getCode());
        codeList.add(codeDto);
    }

    private void addLogiCodeToList(LogiCode entity, LinkedList<CodeDto> codeList) {
        CodeDto codeDto = new CodeDto();
        codeDto.setCode(entity.getCode());
        codeDto.setCodeValue(entity.getCodeValue());
        codeDto.setFullCode(entity.getFullCode());
        codeDto.setParentsCode(entity.getParentsCode().getCode());
        codeList.add(codeDto);
    }

    private void addBizzCodeToList(BizzCode entity, LinkedList<CodeDto> codeList) {
        CodeDto codeDto = new CodeDto();
        codeDto.setCode(entity.getCode());
        codeDto.setCodeValue(entity.getCodeValue());
        codeDto.setFullCode(entity.getFullCode());
        codeDto.setParentsCode(entity.getParentsCode().getCode());
        codeList.add(codeDto);
    }

    private void addUkcdCodeToList(UkcdCode entity, LinkedList<CodeDto> codeList) {
        CodeDto codeDto = new CodeDto();
        codeDto.setCode(entity.getCode());
        codeDto.setCodeValue(entity.getCodeValue());
        codeDto.setFullCode(entity.getFullCode());
        codeDto.setParentsCode(entity.getParentsCode().getCode());
        codeList.add(codeDto);
    }

    private void addStckCodeToList(StckCode entity, LinkedList<CodeDto> codeList) {
        CodeDto codeDto = new CodeDto();
        codeDto.setCode(entity.getCode());
        codeDto.setCodeValue(entity.getCodeValue());
        codeDto.setFullCode(entity.getFullCode());
        codeDto.setParentsCode(entity.getParentsCode().getCode());
        codeList.add(codeDto);
    }
    private void addKisCodeToList(KisCode entity, LinkedList<CodeDto> codeList) {
        CodeDto codeDto = new CodeDto();
        codeDto.setCode(String.valueOf(entity.getCode()));
        codeDto.setCodeValue(entity.getCodeValue());
        codeDto.setFullCode(entity.getFullCode());
        codeDto.setParentsCode(entity.getParentsCode().getCode());
        codeList.add(codeDto);
    }

}