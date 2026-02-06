package com.example.support.service;

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
  public Ticket createTicket(Ticket ticket) {
    ticket.setStatus("OPEN");
    ticket.setCreatedAt(LocalDateTime.now());
    return ticketRepository.save(ticket);
  }
  public List<Ticket> getAllTickets() {
    return ticketRepository.findAll();
  }
  public Ticket getTicketById(Long id) {
    return ticketRepository.findById(id).orElseThrow(() -> new RunTimeException("Ticket not found"));
  }
}
