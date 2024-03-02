package com.gdh.assetMenagement.dto.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KisCertificationDto {
    private String userIdx;
    private String approvalKey;
    private String accessToken;
    private String tokenType;
    private Instant accessTokenExpired;

    public String getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(String userIdx) {
        this.userIdx = userIdx;
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
