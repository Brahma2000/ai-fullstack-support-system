import React, { useState } from "react";
import { createTicket } from "../services/api";

function TicketForm({ onTicketCreated }) {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        const ticket = { title, description };

        await createTicket(ticket);

        setTitle("");
        setDescription("");

        onTicketCreated();
    };
    return (
        <form onSubmit={handleSubmit} style={{ marginBottom: "20px"}}>
            <h1 style={{ textAlign: "center" }}>
                AI Support Dashboard
            </h1>

            <input 
               type="text"
               placeholder="Title"
               value={title}
               onChange={(e) => setTitle(e.target.value)}
               style={{
                width: "100%",
                padding: "10px",
                marginbottom: "10px",
                borderRadius: "5px",
                border: "1px solid #ccc"
               }}
            />

            <textarea
               placeholder="Description"
               value={description}
               onChange={(e) => setDescription(e.target.value)}
               style={{
                width: "100%",
                padding: "10px",
                marginbottom: "10px",
                borderRadius: "5px",
                border: "1px solid #ccc"
               }}
            />

            <button 
              type="submit"
              style={{
                padding: "10px 20px",
                backgroundColor: "#007bff",
                color: "#fff",
                border: "none",
                borderRadius: "5px",
                cursor: "pointer"
              }}
            >
                Create Ticket
            </button>
        </form>
    );
}

export default TicketForm;