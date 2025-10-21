package sio.tp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import sio.tp2.entities.Etat;

import java.util.List;

@Repository
public interface EtatRepository extends JpaRepository<Etat, Integer>
{
    @Override
    List<Etat> findAll();
    Etat findByNomEtat(String nomEtat);
}
