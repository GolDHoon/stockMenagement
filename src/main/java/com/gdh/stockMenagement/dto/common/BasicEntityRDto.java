package com.gdh.stockMenagement.dto.common;

import com.gdh.stockMenagement.dto.rDto.UserRDto;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.gdh.stockMenagement.entity.common.BasicEntity}
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicEntityRDto implements Serializable {
    private static final long serialVersionUID = 1L;
    Boolean isUse;
    Boolean isDel;
    Instant regDate;
    UserRDto regUser;
    Instant modDate;
    UserRDto modUser;
    Instant delDate;
    UserRDto delUser;
}