package com.gdh.stockMenagement.dto.rDto;

import com.gdh.stockMenagement.dto.common.BasicEntityRDto;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.gdh.stockMenagement.entity.Code}
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeRRDto extends BasicEntityRDto implements Serializable {
    private static final long serialVersionUID = 1L;
    UUID id;
    String code;
    String codeName;
    String discription;
}