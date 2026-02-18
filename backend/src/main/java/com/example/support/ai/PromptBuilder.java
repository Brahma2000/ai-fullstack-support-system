package com.example.support.ai;
public class PromptBuilder {
  public static String buildTicketPromptV1(String title, String description) {
    return """
    you are a support ticket assistant.
    Analyze the following ticket and respond ONLY in JSON format.

    Required JSON structure:
      {
         "summary": "2 line concise summary",
         "priority": "LOW | MEDIUM | HIGH"
      }
    Ticket title: %s
    Ticket Description: %s
    Do not add explanations.
    """.formatted(title, description);
  }
}
