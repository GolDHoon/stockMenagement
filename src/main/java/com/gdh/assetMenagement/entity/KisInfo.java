package com.gdh.assetMenagement.entity;

import com.gdh.assetMenagement.entity.common.BasicEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;


@ToString
@Accessors(chain = true)
@Entity
@Table(name = "TB_KIS_INFO")
public class KisInfo extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Idx", nullable = false)
    private UUID id;

    @Column(name = "KisCode", nullable = false)
    private String kisCode;

    @Column(name = "UserIdx", nullable = false)
    private String userIdx;

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