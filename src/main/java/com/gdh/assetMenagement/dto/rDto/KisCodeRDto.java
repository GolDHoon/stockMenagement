package com.gdh.assetMenagement.dto.rDto;

import com.gdh.assetMenagement.dto.common.BasicEntityRDto;
import com.gdh.assetMenagement.entity.StckCode;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.gdh.assetMenagement.entity.KisCode}
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KisCodeRDto extends BasicEntityRDto implements Serializable {
    private static final long serialVersionUID = 1L;
    UUID id;
    Integer code;
    String fullCode;
    String codeValue;
    String parentsCode;
    String fullParentsCode;
    String discription;
}