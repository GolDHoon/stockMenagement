package com.gdh.assetMenagement.dto.common;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@ToString
@Component
public class CommonComponent {
    private LinkedList<CodeDto> codeList = new LinkedList<>();

    public LinkedList<CodeDto> getCodeList() {
        return codeList;
    }

    public void setCodeList(LinkedList<CodeDto> codeList) {
        this.codeList = codeList;
    }
}
