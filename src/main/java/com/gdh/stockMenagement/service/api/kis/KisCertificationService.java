package com.gdh.stockMenagement.service.api.kis;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class KisCertificationService {

    @Value("${custom.api.kis.domain}")
    private String domain;

    @Value("${custom.api.kis.appKey}")
    private String appKey;

    @Value("${custom.api.kis.scretKey}")
    private String scretKey;

    public void receiveWebSocketAccessKey() throws Exception {
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


        System.out.println(response.body());
        System.out.println(approvalKey);
    }
}
