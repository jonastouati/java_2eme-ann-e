package sio.tp1.services;

import org.springframework.stereotype.Service;
import sio.tp1.entities.Rayon;
import sio.tp1.repositories.RayonRepository;

import java.util.List;

@Service
public class RayonService
{
    public RayonRepository RayonRepository;
    public void RayonService(RayonRepository RayonRepository)
    {
        this.RayonRepository = RayonRepository;
    }

    public List<Rayon> getAllRayon()
    {
        return RayonRepository.findAll();
    }
}
