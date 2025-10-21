package sio.tp2.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sio.tp2.dto.TicketUser;
import sio.tp2.entities.Ticket;
import sio.tp2.entities.User;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>
{
    @Override
    List<Ticket> findAll();

@Query ("select new sio.tp2.dto.TicketUser(t.id,t.nomTicket,t.dateTicket,e.nomEtat) from Ticket t join Etat e on t.numEtat.id = e.id where t.numUser.id =:idUser ")
    List<TicketUser> findTicketsByNumUser(@Param("idUser") int idUser);

@Override
    <S extends Ticket> S save(S entity);

// La méthode save sert a faire une insertion en base et/ou un update

}
