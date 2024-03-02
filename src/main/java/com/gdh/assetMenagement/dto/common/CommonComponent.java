package com.gdh.assetMenagement.dto.common;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CommonComponent {
    private LinkedList<CodeDto> codeList = new LinkedList<>();
    private Map<String, KisCertificationDto> kisCertificationDtoMap = new HashMap<>();

    public LinkedList<CodeDto> getCodeList() {
        return codeList;
    }

    public void setCodeList(LinkedList<CodeDto> codeList) {
        this.codeList = codeList;
    }

    public Map<String, KisCertificationDto> getKisCertificationDtoMap() {
        return kisCertificationDtoMap;
    }

    public void setKisCertificationDtoMap(Map<String, KisCertificationDto> kisCertificationDtoMap) {
        this.kisCertificationDtoMap = kisCertificationDtoMap;
    }
}
