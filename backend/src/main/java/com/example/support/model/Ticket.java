package com.example.support.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LacalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
  @Id
  @GenerateValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String title;

  @Column(length = 2000)
  private String aiSummary;
  private String description;

  private String priority;

  private LocalDateTime createdAt;
}
