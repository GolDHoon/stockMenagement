package com.gdh.assetMenagement.dto.common;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * DTO for {@link com.gdh.assetMenagement.entity.common.BasicEntity}
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BasicEntityRDto implements Serializable {
    Boolean isUse;
    Boolean isDel;
    Instant regDate;
    UUID regUser;
    Instant modDate;
    UUID modUser;
    Instant delDate;
    UUID delUser;

    public Boolean getUse() {
        return isUse;
    }

    public void setUse(Boolean use) {
        isUse = use;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    public Instant getRegDate() {
        return regDate;
    }

    public void setRegDate(Instant regDate) {
        this.regDate = regDate;
    }

    public UUID getRegUser() {
        return regUser;
    }

    public void setRegUser(UUID regUser) {
        this.regUser = regUser;
    }

    public Instant getModDate() {
        return modDate;
    }

    public void setModDate(Instant modDate) {
        this.modDate = modDate;
    }

    public UUID getModUser() {
        return modUser;
    }

    public void setModUser(UUID modUser) {
        this.modUser = modUser;
    }

    public Instant getDelDate() {
        return delDate;
    }

    public void setDelDate(Instant delDate) {
        this.delDate = delDate;
    }

    public UUID getDelUser() {
        return delUser;
    }

    public void setDelUser(UUID delUser) {
        this.delUser = delUser;
    }
}