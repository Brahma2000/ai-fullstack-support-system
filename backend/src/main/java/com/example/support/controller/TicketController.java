package com.example.support.controller;

import com.example.support.model.Ticket;
import com.example.support.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

  private final TicketService ticketService;

  @Operation(summary = "Create a new support ticket")
  @PostMapping
  public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) {
    return ResponseEntity.ok(ticketService.createTicket(ticket));
  }

  @Operation(summary = "Get all support tickets")
  @GetMapping
  public List<Ticket> getAllTickets() {
    return ticketService.getAllTickets();
  }

  @Operation(summary = "Get ticket by ID")
  @GetMapping("/{id}")
  public Ticket getTicket(@PathVariable Long id) {
    return ticketService.getTicketById(id);
  }
}
