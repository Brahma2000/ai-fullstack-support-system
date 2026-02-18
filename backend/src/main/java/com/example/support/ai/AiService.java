package com.example.support.ai;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AiService {
  private final OpenAiClient openAiClient;
  private final ObjectMapper objectMapper = new ObjectMapper();

  public AiTicketResponse analyzeTicket(String title, String description) {
    String prompt = PromptBuilder.buildTicketPromptV1(title, description);
    String rawResponse = openAiClient.getStructuredResponse(prompt);

    if (rawResponse == null) {
      log.warn("AI returned null response");
      return null;
    }
    try {
      AiTcketResponse aiResponse = objectMapper.readValue(rawResponse, AiTicketResponse.class);

      if (aiResponse.getSummary() == null || aiResponse.getpriority() == null) {
        log.warn("AI response missing required fields");
        return null;
      }
      if (!isValidPriority(aiResponse.getPriority())) {
        log.warn("Invalid priority returned from AI: {}", aiResponse.getPriority());
        return null;
      }
      return aiResponse;
    } catch (Exception e) {
      log.error("Failed to parse AI response", e);
      return null;
    }
  }

  private boolean isValidPriority(String priority) {
    return priority.equalsIgnoreCase("LOW") || priority.equalsIgnoreCase("MEDIUM") || priority.equalsIgnoreCase("HIGH");
  }
}
