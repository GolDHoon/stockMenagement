package com.gdh.assetMenagement.service.api.kis;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class KisCertificationService {

    @Value("${custom.api.kis.domain}")
    String domain;

    public String receiveWebSocketAccessKey(String appKey, String scretKey) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        StringBuilder url = new StringBuilder(domain);
        url.append("/oauth2/Approval");

        // JSON 객체 생성
        JSONObject body = new JSONObject();
        body.put("grant_type", "client_credentials");
        body.put("appkey", appKey);
        body.put("secretkey", scretKey);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url.toString())) // change with your actual API URL
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.body());

        String approvalKey = objectMapper.writeValueAsString(responseJson.get("approval_key"));

        return approvalKey;
    }

    public Map<String, String> receiveAccessToken(String appKey, String scretKey) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        StringBuilder url = new StringBuilder(domain);
        url.append("/oauth2/tokenP");

        // JSON 객체 생성
        JSONObject body = new JSONObject();
        body.put("grant_type", "client_credentials");
        body.put("appkey", appKey);
        body.put("secretkey", scretKey);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url.toString())) // change with your actual API URL
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.body());

        Map<String, String> result = new HashMap<String, String>();
        result.put("accessToken", objectMapper.writeValueAsString(responseJson.get("access_token")));
        result.put("tokenType", objectMapper.writeValueAsString(responseJson.get("token_type")));
        result.put("accessTokenExpired", objectMapper.writeValueAsString(responseJson.get("access_token_token_expired")));

        return result;
    }
}
