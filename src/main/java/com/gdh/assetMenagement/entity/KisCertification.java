package com.gdh.assetMenagement.entity;

import com.gdh.assetMenagement.entity.common.BasicEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@ToString
@Accessors(chain = true)
@Entity
@Table(name = "TB_KIS_CERTIFICATION")
public class KisCertification extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Idx", nullable = false)
    private UUID id;

    @Column(name = "KisInfoIdx", nullable = false)
    private UUID kisInfoIdx;

    @Nationalized
    @Column(name = "AppKey", length = 36)
    private String appKey;

    @Nationalized
    @Column(name = "AppSecret", length = 180)
    private String appSecret;

    @Nationalized
    @Column(name = "ApprovalKey", length = 286)
    private String approvalKey;

    @Nationalized
    @Column(name = "AccessToken", length = 350)
    private String accessToken;

    @Nationalized
    @Column(name = "TokenType", length = 20)
    private String tokenType;

    @Column(name = "accessTokenExpired")
    private Instant accessTokenExpired;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getKisInfoIdx() {
        return kisInfoIdx;
    }

    public void setKisInfoIdx(UUID kisInfoIdx) {
        this.kisInfoIdx = kisInfoIdx;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getApprovalKey() {
        return approvalKey;
    }

    public void setApprovalKey(String approvalKey) {
        this.approvalKey = approvalKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Instant getAccessTokenExpired() {
        return accessTokenExpired;
    }

    public void setAccessTokenExpired(Instant accessTokenExpired) {
        this.accessTokenExpired = accessTokenExpired;
    }
}