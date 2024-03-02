package com.gdh.assetMenagement.dto.rDto;

import com.gdh.assetMenagement.dto.common.BasicEntityRDto;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.gdh.assetMenagement.entity.KisInfo}
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KisInfoRDto extends BasicEntityRDto implements Serializable {
    private static final long serialVersionUID = 1L;
    UUID id;
    String kisCode;
    String userIdx;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getKisCode() {
        return kisCode;
    }

    public void setKisCode(String kisCode) {
        this.kisCode = kisCode;
    }

    public String getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(String userIdx) {
        this.userIdx = userIdx;
    }
}