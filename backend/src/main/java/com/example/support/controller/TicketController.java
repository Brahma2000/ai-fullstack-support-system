package com.example.support.controller;

import com.example.support.model.Ticket;
import com.example.support.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

  private final TicketService ticketService;

  @PostMapping
  public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) {
    return ResponseEntity.ok(ticketService.createTicket(ticket));
  }

  @GetMapping
  public List<Ticket> getAllTickets() {
    return ticketService.getAllTickets();
  }

  @GetMapping("/{id}")
  public Ticket getTicket(@PathVariable Long id) {
    return ticketService.getTicketById(id);
  }
}
