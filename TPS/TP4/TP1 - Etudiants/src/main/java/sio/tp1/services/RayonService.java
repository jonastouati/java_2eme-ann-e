package sio.tp1.services;

import org.springframework.stereotype.Service;
import sio.tp1.entities.Rayon;
import sio.tp1.entities.Secteur;
import sio.tp1.repositories.EmployeRepository;
import sio.tp1.repositories.RayonRepository;

import java.util.List;

@Service
public class RayonService
{
    private EmployeRepository employeRepository;
    private RayonRepository RayonRepository;

    public RayonService(RayonRepository rayonRepository, EmployeRepository employeRepository)
    {
        this.RayonRepository = rayonRepository;
        this.employeRepository= employeRepository;
    }

    public List<Rayon> getAllRayonByIdSecteur(Secteur secteur)
    {
        return RayonRepository.findByNumSecteur(secteur);
    }
}
