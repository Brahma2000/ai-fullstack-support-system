package com.example.support.ai;

import lombok.Data;

@Data
public class AiTicketResponse {
  private String summary;
  private String priority;

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

}
