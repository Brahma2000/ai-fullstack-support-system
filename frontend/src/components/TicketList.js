import React from "react";

function TicketList({ tickets }) {
    return (
        <div style={{ marginTop: "30px" }}>
            <h2>Tickets</h2>

            {tickets.map((ticket) => (
                <div 
                   key={ticket.id} 
                   style={{ 
                    border: "1px solid #ddd",
                    borderRadius: "10px",
                    padding: "15px", 
                    marginBottom: "15px",
                    boxShadow: "0 2px 6px rgba(0,0,0,0.1)",
                    backgroundColour: "#fff"
                    }}
                >
                    <h3>{ticket.title}</h3>
                    <p>{ticket.description}</p>

                    <p><strong>Status:</strong> {ticket.status}</p>
                    <p><strong>AI Summary:</strong> {ticket.aiSummary}</p>
                    <p>
                        <strong>Priority:</strong>{" "}
                        <span
                          style={{
                            color:
                               ticket.aiPriority === "HIGH"
                                 ? "red"
                                 :ticket.aiPriority === "MEDIUM"
                                 ? "orange"
                                 : "green",
                            fontWeight: "bold"
                          }}
                        >
                            {ticket.aiPriority}
                        </span>
                    </p>
                </div>
            ))}
        </div>
    );
}

export default TicketList;