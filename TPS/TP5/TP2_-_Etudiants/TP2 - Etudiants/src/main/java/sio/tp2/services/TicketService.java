package sio.tp2.services;

import org.springframework.stereotype.Service;
import sio.tp2.dto.TicketUser;
import sio.tp2.entities.Etat;
import sio.tp2.entities.Ticket;
import sio.tp2.entities.User;
import sio.tp2.repositories.EtatRepository;
import sio.tp2.repositories.TicketRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService
{
    private final EtatRepository etatRepository;
    private final TicketRepository ticketRepository;

    public TicketService(EtatRepository etatRepository, TicketRepository ticketRepository) {
        this.etatRepository = etatRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> findAll()
    {
        return ticketRepository.findAll();
    }
    public List<TicketUser> getTicketsByUser(int idUser)
    {
        return ticketRepository.findTicketsByNumUser(idUser);
    }

    public void insererNouveauTicket(User user, String nomTicket, String nomEtat)
    {
        Ticket nouveauTicket = new Ticket();
        nouveauTicket.setNomTicket(nomTicket);
        nouveauTicket.setDateTicket(LocalDate.now());
        nouveauTicket.setNumUser(user);

        Etat etat = etatRepository.findByNomEtat(nomEtat);
        nouveauTicket.setNumEtat(etat);
        ticketRepository.save(nouveauTicket);
    }
}
