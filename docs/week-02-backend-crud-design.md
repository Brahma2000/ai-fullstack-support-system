# Week 2 - Backend ticket CRUD  Design

## Objective

Build the core backend foundation for the support system before introducing AI features.

This week focuses on implementing a clean, layered backend architecture using Spring Boot and JPA.

---

## Architecture Overview

The backend follows a standard layered design:
Controller -> Service -> Repository -> Database

### Responsibilities

#### Controller Layer
- Handles HTTP requests
- Validates incoming data
- Returns API responses

#### Service Layer
- Contains Business Logic
- Controls ticket creation workflow
- Future integration point for AI services

#### Repository Layer
- Handles database interactions
- Uses Spring Data JPA

#### Model Layer
- Defines database entities

---

## Ticket Entity Design
The Ticket entity represents a support request submitted by users.

### Fields
| Field  | Description |
|--------|-------------|
| id | Unique identifier |
| title | Short Summary of issue |
| description | Detailed problem explanation |
| status | Ticket state (OPEN, CLOSED, etc.) |
| priority | Urgency Level |
| createdAt | Timestamp of ticket creation |

---

## API Endpoints Implemented

### Create Ticket

POST/tickets
Creates a new support ticket.

---

### Get All Tickets
GET/tickets
Returns all stored tickets.

---

### Get Ticket By ID
GET/tickets/{id}
Fetches ticket details by identifier

---

## AI Integration Planning

AI functionality is intentionally not implemented in week 2.
However, the service layer is designed to allow easy AI integration later.

Future AI capabilities will include:

- Ticket summarization
- Automatic priority classification
- Response suggestions

The AI logic will be introduced inside the service layer to maintain seperation of concerns.

---

## Key Design Principles Followed

- Layered architecture
- Seperation of concerns
- Backend-controlled workflows
- Scalable foundation for AI features
- Clean REST API design

---

## Future Enhancements

Week 3 will introduce:

- AI Service Layer
- External Ai API integration
- Prompt design strategies
- Error handling and fallback logic
