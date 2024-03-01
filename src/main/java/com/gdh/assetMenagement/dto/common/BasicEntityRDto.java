package com.gdh.assetMenagement.dto.common;

import com.gdh.assetMenagement.dto.rDto.UserRDto;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.gdh.assetMenagement.entity.common.BasicEntity}
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