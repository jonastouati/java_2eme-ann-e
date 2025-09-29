package sio.tp1.services;

import org.springframework.stereotype.Service;
import sio.tp1.repositories.TravaillerRepository;

@Service
public class TravaillerService
{
    private TravaillerRepository travaillerRepository;

    public TravaillerService(TravaillerRepository travaillerRepository)
    {
        this.travaillerRepository = travaillerRepository;
    }

    public int getTotalHeureseSecteur(int idSecteur)
    {
        return TravaillerRepository.
    }
}
