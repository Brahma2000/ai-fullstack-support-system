package com.example.support.service;

import com.example.support.ai.AiService;
import com.example.support.ai.AiTicketResponse;
import com.example.support.model.Ticket;
import com.example.support.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.support.monitoring.AIUsageMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

  private final TicketRepository ticketRepository;
  private final AiService aiService;
  private final AIUsageMonitor usageMonitor;
  private static final Logger logger = LoggerFactory.getLogger(TicketService.class);

  public Ticket createTicket(Ticket ticket) {

    if (usageMonitor.isLimitExceeded()) {
      logger.warn("AI usage limit exceeded!");
      throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "AI usage limit exceeded. Request blocked.");
    }

    usageMonitor.incrementUsage();
    logger.info("AI request count: {}", usageMonitor.getUsage());

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

  public Ticket getTicketById(Long id) {
    return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
  }
}
