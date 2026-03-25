import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

export const createTicket = (ticket) => {
    return axios.post(`${API_BASE_URL}/tickets`, ticket);
};

export const getTickets = () => {
    return axios.get(`${API_BASE_URL}/tickets`);
};