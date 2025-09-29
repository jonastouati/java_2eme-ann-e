package sio.tp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sio.tp1.entities.Travailler;

@Repository
public interface TravaillerRepository extends JpaRepository<Travailler, Integer>
{
    @Query("select sum(t.temps) from Travailler as t  where t.codeRayon.numSecteur.id=:idSecteur")
    public int totalHeuresSecteur(@Param("idSecteur")int idSecteur);
}
