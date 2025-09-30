package sio.tp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sio.tp1.dto.EmployeRayon;
import sio.tp1.entities.Employe;
import sio.tp1.entities.Travailler;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TravaillerRepository extends JpaRepository<Travailler, Integer>
{
    @Query("select sum(t.temps) from Travailler as t  where t.codeRayon.numSecteur.id =:idSecteur")
    public int totalHeuresSecteur(@Param("idSecteur")int idSecteur);

    @Query("select  new sio.tp1.dto.EmployeRayon(e.id,e.nomEmploye,t.id.date,t.temps) from Employe e join Travailler  t on e.id=t.codeEmploye.id where  t.codeRayon.id= :idRayon")
    public List<EmployeRayon> findAllEmployeRayon(@Param("idRayon")int idRayon);

    @Query("select sum(t.temps) from Travailler t where t.codeRayon.id=:idRayon")
    public int totalHeuresTemps(@Param("idRayon")int idRayon);

    long countBycodeEmployeAndIdDate(Employe codeEmploye, LocalDate date);
    @Override
    <S extends Travailler> S saveAndFlush(S entity);
}

