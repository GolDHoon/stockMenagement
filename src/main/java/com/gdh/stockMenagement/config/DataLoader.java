package com.gdh.stockMenagement.config;

import com.gdh.stockMenagement.dto.common.CodeDto;
import com.gdh.stockMenagement.dto.common.CommonComponent;
import com.gdh.stockMenagement.entity.Code;
import com.gdh.stockMenagement.entity.LogiCode;
import com.gdh.stockMenagement.entity.UkcdCode;
import com.gdh.stockMenagement.repository.basic.CodeRepository;
import com.gdh.stockMenagement.repository.basic.LogiCodeRepository;
import com.gdh.stockMenagement.repository.basic.UkcdCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class DataLoader implements CommandLineRunner {

    private final CommonComponent commonComponent;
    private final CodeRepository codeRepository;
    private final LogiCodeRepository logiCodeRepository;
    private final UkcdCodeRepository ukcdCodeRepository;

    private final Lock lock = new ReentrantLock();

    @Autowired
    public DataLoader(CommonComponent commonComponent, CodeRepository codeRepository, LogiCodeRepository logiCodeRepository, UkcdCodeRepository ukcdCodeRepository) {
        this.commonComponent = commonComponent;
        this.codeRepository = codeRepository;
        this.logiCodeRepository = logiCodeRepository;
        this.ukcdCodeRepository = ukcdCodeRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        updateCodeList();
    }

    private void updateCodeList() {
        LinkedList<CodeDto> codeList = new LinkedList<>();

        codeRepository.findAll().forEach(entity -> addCodeToList(entity, codeList));
        logiCodeRepository.findAll().forEach(entity -> addLogiCodeToList(entity, codeList));
        ukcdCodeRepository.findAll().forEach(entity -> addUkcdCodeToList(entity, codeList));

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
        codeDto.setCodeName(entity.getCodeName());
        codeDto.setFullCode(entity.getCode());
        codeList.add(codeDto);
    }

    private void addLogiCodeToList(LogiCode entity, LinkedList<CodeDto> codeList) {
        CodeDto codeDto = new CodeDto();
        codeDto.setCode(entity.getCode());
        codeDto.setCodeName(entity.getCodeName());
        codeDto.setFullCode(entity.getFullCode());
        codeDto.setParentsCode(entity.getParentsCode().getCode());
        codeList.add(codeDto);
    }

    private void addUkcdCodeToList(UkcdCode entity, LinkedList<CodeDto> codeList) {
        CodeDto codeDto = new CodeDto();
        codeDto.setCode(entity.getCode());
        codeDto.setCodeName(entity.getCodeName());
        codeDto.setFullCode(entity.getFullCode());
        codeDto.setParentsCode(entity.getParentsCode().getCode());
        codeList.add(codeDto);
    }
}