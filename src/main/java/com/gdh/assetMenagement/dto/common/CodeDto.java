package com.gdh.assetMenagement.dto.common;

import lombok.*;

@ToString
public class CodeDto {
    String fullCode;
    String code;
    String codeValue;
    String parentsCode;

    public String getFullCode() {
        return fullCode;
    }

    public String getCode() {
        return code;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public String getParentsCode() {
        return parentsCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public void setParentsCode(String parentsCode) {
        this.parentsCode = parentsCode;
    }
}
