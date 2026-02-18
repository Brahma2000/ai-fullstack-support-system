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
@Table(name = "tickets")
public class Ticket {
  @Id
  @GenerateValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false, length = 3000)
  private String description;
  private String status;

  private LocalDateTime createdAt;

  @Column(length = 2000)
  private String aiSummary;
  private String aiPriority;
}
