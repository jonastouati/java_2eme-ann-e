package sio.tp1.dto;

import java.time.LocalDate;

public class EmployeRayon
{
    private int idEmploye;
    private String nomEmploye;
    private LocalDate date;
    private int temps;

    public EmployeRayon(int idEmploye, String nomEmploye, LocalDate date, int temps) {
        this.idEmploye = idEmploye;
        this.nomEmploye = nomEmploye;
        this.date = date;
        this.temps = temps;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }
}
