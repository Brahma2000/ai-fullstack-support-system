# Week 4 - Prompt Engineering & Structured Output

## Objective
Improve reliability of AI integration using structured responses.

---

## What Changed?

- Introduced PromptBuilder (Versioned prompts)
- Enforced strict JSON response format
- Added AI response DTO
- Implementing JSON parsing validation

---

## Why Structured Output?
Free-text responses are unpredictable.

Structured JSON allows:
- Easier parsing
- Validation
- Safer production systems

---

## Prompt Versioning

Prompts are versioned (v1) to allow:
- Experimentation
- Rollback
- Performance comparsion

---

## Fail-Safe Handling

If parsing fails:
- Ticket still gets created
- AI fields remain optional
