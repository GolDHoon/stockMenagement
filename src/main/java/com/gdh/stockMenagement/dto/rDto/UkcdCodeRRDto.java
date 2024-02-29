package com.gdh.stockMenagement.dto.rDto;

import com.gdh.stockMenagement.dto.common.BasicEntityRDto;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.gdh.stockMenagement.entity.UkcdCode}
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UkcdCodeRRDto extends BasicEntityRDto implements Serializable {
    private static final long serialVersionUID = 1L;
    UUID id;
    String code;
    String fullCode;
    String codeName;
    LogiCodeRRDto parentsCode;
    String fullParentsCode;
    String discription;
}