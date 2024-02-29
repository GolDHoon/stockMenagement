package com.gdh.stockMenagement.dto.common;

import lombok.*;

@ToString
public class CodeDto {
    String fullCode;
    String code;
    String codeName;
    String parentsCode;

    public String getFullCode() {
        return fullCode;
    }

    public String getCode() {
        return code;
    }

    public String getCodeName() {
        return codeName;
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

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setParentsCode(String parentsCode) {
        this.parentsCode = parentsCode;
    }
}
