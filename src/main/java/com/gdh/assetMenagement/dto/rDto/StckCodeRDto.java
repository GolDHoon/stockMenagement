package com.gdh.assetMenagement.dto.rDto;

import com.gdh.assetMenagement.dto.common.BasicEntityRDto;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.gdh.assetMenagement.entity.StckCode}
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StckCodeRDto extends BasicEntityRDto implements Serializable {
    private static final long serialVersionUID = 1L;
    UUID id;
    String code;
    String fullCode;
    String codeValue;
    String parentsCode;
    String fullParentsCode;
    String discription;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullCode() {
        return fullCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getParentsCode() {
        return parentsCode;
    }

    public void setParentsCode(String parentsCode) {
        this.parentsCode = parentsCode;
    }

    public String getFullParentsCode() {
        return fullParentsCode;
    }

    public void setFullParentsCode(String fullParentsCode) {
        this.fullParentsCode = fullParentsCode;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}