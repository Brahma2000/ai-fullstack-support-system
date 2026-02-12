package com.example.support.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotypr.Service;

@Service
@RequiredArgsConstructor
public class AiService {
  private final OpenAiClient client;
  public String summarizeTicket(String title, String description) {
    String prompt = """
    Summarize the support ticket in 2 concise lines.

    Title: %s
    Description: %s
    """.formatted(title, description);
    return client.summarize(prompt);
  }
}
