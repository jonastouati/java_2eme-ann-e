package sio.tp1.services;

import org.springframework.stereotype.Service;
import sio.tp1.dto.EmployeRayon;
import sio.tp1.repositories.TravaillerRepository;

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
}
