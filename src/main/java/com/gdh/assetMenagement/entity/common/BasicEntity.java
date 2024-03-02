package com.gdh.assetMenagement.entity.common;

import com.gdh.assetMenagement.entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
public abstract class BasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "IsUse", nullable = false)
    private Boolean isUse = false;

    @Column(name = "IsDel", nullable = false)
    private Boolean isDel = false;

    @Column(name = "RegDate", nullable = false)
    private Instant regDate;

    @Column(name = "RegUser", nullable = false)
    private UUID regUser;

    @Column(name = "ModDate", nullable = false)
    private Instant modDate;

    @Column(name = "ModUser")
    private UUID modUser;

    @Column(name = "DelDate")
    private Instant delDate;

    @Column(name = "DelUser")
    private UUID delUser;

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
