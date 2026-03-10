package com.example.support.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tickets")
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @NotBlank(message = "Title cannot be empty")
  @Size(max = 100)
  private String title;

  @Column(nullable = false, length = 500)
  @NotBlank(message = "Description cannot be empty")
  @Size(max = 500)
  private String description;
  private String status;

  private LocalDateTime createdAt;

  @Column(length = 2000)
  private String aiSummary;
  private String aiPriority;

}
