# Week 3 - AI Integration

## Objective
Integrate AI into backend workflow while maintaining clean architecture.

---

## Design Approach

AI is implemented as a seperate service layer.
Controller -> Service -> AI Service -> OpenAI API

---

## AI Feature Implemented
Ticket summarization

---

## Key Design Decisions

- AI calls placed inside servicelayer
- AI failures handled gracefully
- Only AI output stored
- Prompts not persisted

## Reliability Considerations

- Timeout protection
- Logging
- Fallback if AI unavailable

## Future Enhancements

- Prompt versioning
- Structured JSON responses
- Cost monitoring
