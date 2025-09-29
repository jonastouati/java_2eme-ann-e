package sio.tp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sio.tp1.entities.Employe;
import sio.tp1.entities.Rayon;

import java.util.List;



@Repository

public interface RayonRepository extends JpaRepository<Rayon,Integer>
{
    @Override
    List<Rayon> findAll();



}
