# AI-Enhanced Full Stack Support System

This project demonstrates how to incrementally add AI capabilities to a traditional full-stack application.

## Tech Stack
- Frontend: React.js
- Backend: Spring Boot
- AI: OpenAI / Azure OpenAI
- Database: PostgreSQL (H2 for dev)

  ## Architecture (Week 1)

  Frontend -> Backend APT -> AI Service -> Database

  The frontend never communicates directly with the AI.
  All AI calls are controlled by the backend

  ## Roadmap
  - Week 1: Achitecture & Planning
  - Week 2: Ticket CRUD
  - Week 3: AI summarization
  - Week 4: AI classification
  - Week 5+: RAG, caching, streaming
