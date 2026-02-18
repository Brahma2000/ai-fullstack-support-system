package com.example.support.ai;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.sterotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.*;

@Slf4j
@Component
public class OpenAiClient {
  @Value("${openai.api.key}")
  private String apiKey;

  private final RestTemplate restTemplate;

  public OpenAiClient(RestTemplateBuilder builder) {
    this.restTemplate = builder
      .setConnectTimeout(Duration.ofSeconds(5))
      .setReadTimeout(Duration.ofSeconds(10))
      .build();
  }
  
  public String getStructuredResponse(String prompt) {
    String url = "https://api.openai.com/v1/chat/completions";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(apiKey);

    Map<String, Object> message = Map.of(
      "role", "user", 
      "content", prompt
    );

    Map<String, Object> request = new HashMap<>();
    request.put("model", "gpt-3.5-turbo");
    request.put("messages", List.of(message));
    request.put("temperature", 0);

    try {
      HttpEntity<Map<String, Object>> entity = 
        new HttpEntity<>(request, headers);

      ResponseEntity<Map> response =
        restTemplate.postForEntity(url, entity, Map.class);

      Map choice = (Map)((List)response.getBody().get("choices")).get(0);
      Map msg = (Map)choice.get("message");

      return msg.get("content").toString();
    } catch (Exception ex) {
      log.error("AI call failed", ex);
      return null;
    }
