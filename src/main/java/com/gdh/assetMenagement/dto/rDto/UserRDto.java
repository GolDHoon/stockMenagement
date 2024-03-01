package com.gdh.assetMenagement.dto.rDto;

import com.gdh.assetMenagement.dto.common.BasicEntityRDto;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.gdh.assetMenagement.entity.User}
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRDto extends BasicEntityRDto implements Serializable {
    private static final long serialVersionUID = 1L;
    UUID id;
    String userId;
    String password;
    UkcdCodeRRDto ukcd;
}