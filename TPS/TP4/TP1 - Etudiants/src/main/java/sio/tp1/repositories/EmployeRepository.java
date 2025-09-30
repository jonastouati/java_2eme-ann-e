package sio.tp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sio.tp1.entities.Employe;

import java.util.List;
import java.util.Optional;

@Repository

public interface EmployeRepository extends JpaRepository<Employe,Integer>
{
    @Override
    List<Employe> findAll();



}
