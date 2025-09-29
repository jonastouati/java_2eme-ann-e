package sio.tp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sio.tp1.entities.Secteur;

import java.util.List;
@Repository

public interface SecteursRepository extends JpaRepository<Secteur, Integer>
{
    @Override
    List<Secteur> findAll();
}
