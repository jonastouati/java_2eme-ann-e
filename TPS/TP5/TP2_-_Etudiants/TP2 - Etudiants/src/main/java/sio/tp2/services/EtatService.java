package sio.tp2.services;

import org.springframework.stereotype.Service;
import sio.tp2.entities.Etat;
import sio.tp2.repositories.EtatRepository;

import java.util.List;

@Service
public class EtatService
{
    private EtatRepository etatRepository;
    public EtatService(EtatRepository etatRepository)
    {
        this.etatRepository = etatRepository;
    }
    public List<String> getAllNomsEtats()
    {
        return etatRepository.findAll().stream().map(Etat::getNomEtat).toList();
    }
}