package sio.tp1.services;

import org.springframework.stereotype.Service;
import sio.tp1.entities.Employe;
import sio.tp1.repositories.EmployeRepository;

import java.util.List;

@Service
public class EmployeService
{
    public EmployeRepository employeRepository;
    public EmployeService(EmployeRepository employeRepository)
    {
        this.employeRepository = employeRepository;
    }

    public List<Employe> getAllEmploye()
    {
        return employeRepository.findAll();
    }
}
