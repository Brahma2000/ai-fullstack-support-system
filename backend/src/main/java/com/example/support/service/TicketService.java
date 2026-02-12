package com.example.support.service;

import com.example.support.ai.AiService;
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

    String summary = aiService.summarizeTicket(ticket.getTitle(), ticket.getDescription());

    if (summary != null) {
      ticket.setAiSummary(summary);
    }
    return ticketRepository.save(ticket);
  }
  public List<Ticket> getAllTickets() {
    return ticketRepository.findAll();
  }
  public Ticket getTicketById(Long id) {
    return ticketRepository.findById(id).orElseThrow(() -> new RunTimeException("Ticket not found"));
  }
}
