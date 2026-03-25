import React, { useEffect, useState } from "react";
import TicketForm from "./components/TicketForm";
import TicketList from "./components/TicketList";
import { getTickets } from "./services/api";

function App() {
  const [tickets, setTickets] =useState([]);

  const loadTickets = async () => {
    const response = await getTickets();
    setTickets(response.data);
  };

  useEffect(() => {
    loadTickets();
  }, []);
  return (
    <div 
      style={{
        maxWidth: "900px",
        margin: "auto",
        padding: "20px",
        fontFamily: "Arial" 
      }}
    >
      <h1>AI Support System</h1>

      <TicketForm onTicketCreated={loadTickets} />

      <TicketList tickets={tickets} />
    </div>
  );
}

export default App;