package com.example.support.controller;

import com.example.support.model.Ticket;
import com.example.support.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

  private final TicketService ticketService;

  @PostMapping
  public Ticket createTicket(@RequestBody Ticket ticket) {
    return ticketService.createTicket(ticket);
  }

  @GetMapping
  Public List<Ticket> getAllTickets() {
    return ticketService.getAllTickets();
  }

  @GetMapping
  public Ticket getTicket(@PathVariable Long id) {
    return ticketService.getTicketById(id);
  }
}
