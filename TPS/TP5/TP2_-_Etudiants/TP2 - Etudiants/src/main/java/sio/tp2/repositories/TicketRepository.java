package sio.tp2.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sio.tp2.entities.Ticket;
import sio.tp2.entities.User;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>
{
    @Override
    List<Ticket> findAll();

    List<Ticket> findTicketsByNumUser(User numUser);

}
