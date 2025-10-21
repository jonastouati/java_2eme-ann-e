package sio.tp2.services;

import org.springframework.stereotype.Service;
import sio.tp2.entities.Ticket;
import sio.tp2.entities.User;
import sio.tp2.repositories.TicketRepository;

import java.util.List;

@Service
public class TicketService
{
    public TicketRepository TicketRepository;
    public TicketService(TicketRepository ticketRepository)
    {
        this.TicketRepository = ticketRepository;
    }
    public List<Ticket> findAll()
    {
        return TicketRepository.findAll();
    }
    public List<Ticket> getTicketsByUser(User numuser)
    {
        return TicketRepository.findTicketsByNumUser(numuser);
    }
}
