package sio.tp1.services;

import org.springframework.stereotype.Service;
import sio.tp1.entities.Secteur;
import sio.tp1.repositories.SecteursRepository;

import java.util.List;
@Service
public class SecteursService
{
    private SecteursRepository secteursRepository;
    public SecteursService(SecteursRepository secteursRepository)
    {
        this.secteursRepository = secteursRepository;
    }
    public List<Secteur> getAllSecteurs()
    {
        return secteursRepository.findAll();
    }

}
