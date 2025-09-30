package sio.tp1.services;

import org.springframework.stereotype.Service;
import sio.tp1.dto.EmployeRayon;
import sio.tp1.entities.Employe;
import sio.tp1.entities.Rayon;
import sio.tp1.entities.Travailler;
import sio.tp1.entities.TravaillerId;
import sio.tp1.repositories.TravaillerRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TravaillerService
{
    private TravaillerRepository travaillerRepository;

    public TravaillerService(TravaillerRepository travaillerRepository)
    {
        this.travaillerRepository = travaillerRepository;
    }

    public int getTotalHeuresSecteur (int idSecteur)
    {
        return travaillerRepository.totalHeuresSecteur(idSecteur);
    }

    public List<EmployeRayon> getAllEmployesRayon(int idRayon)
    {
        return travaillerRepository.findAllEmployeRayon(idRayon);
    }

    public int getTotalHeureseTemps (int idRayon)
    {
        return travaillerRepository.totalHeuresTemps(idRayon);
    }
    public long dejaTravailler(Employe employe , LocalDate uneDate)
    {
        return travaillerRepository.countBycodeEmployeAndIdDate(employe, uneDate);
    }
    public void insererNouveauTemps(Employe employe, Rayon rayon, LocalDate uneDate, int temps)
    {
        Travailler newTravailler = new Travailler();
        TravaillerId newTravaillerId = new TravaillerId();
        newTravaillerId.setDate(uneDate);
        newTravaillerId.setCodeRayon(rayon.getId());
        newTravaillerId.setCodeEmploye(employe.getId());

        newTravailler.setTemps(temps);
        newTravailler.setCodeRayon(rayon);
        newTravailler.setId(newTravaillerId);
        newTravailler.setCodeEmploye(employe);

        travaillerRepository.saveAndFlush(newTravailler);
    }
}
