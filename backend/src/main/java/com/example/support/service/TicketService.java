package com.example.support.service;

import com.example.support.ai.AiService;
import com.example.support.aiTicketResponse;
import com.example.support.model.Ticket;
import com.example.support.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

  private final TicketRepository ticketRepository;
  private final AiService aiService;
  public Ticket createTicket(Ticket ticket) {
    ticket.setStatus("OPEN");
    ticket.setCreatedAt(LocalDateTime.now());

    AiTicketResponse aiResponse = aiService.analyzeTicket(ticket.getTitle(), ticket.getDescription());
    if (aiResponse != null) {
      ticket.setAiSummary(aiResponse.getSummary());
      ticket.setAiPriority(aiResponse.getPriority());
    }
    return ticketRepository.save(ticket);
  }
  public List<Ticket> getAllTickets() {
    return ticketRepository.findAll();
  }
  public Ticket getTicketByID(Long id) {
    return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
  }
}
