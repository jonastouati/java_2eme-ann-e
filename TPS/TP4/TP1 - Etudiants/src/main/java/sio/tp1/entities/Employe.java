package sio.tp1.entities;

import jakarta.persistence.*;


import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @Column(name = "idEmploye", nullable = false)
    private Integer id;

    @Column(name = "nomEmploye", nullable = false, length = 20)
    private String nomEmploye;

    @Column(name = "prenomEmploye", nullable = false, length = 20)
    private String prenomEmploye;

    @Column(name = "ageEmploye", nullable = false)
    private Integer ageEmploye;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numStatut", nullable = false)
    private sio.tp1.entities.Statut numStatut;

    @OneToMany(mappedBy = "codeEmploye")
    private Set<sio.tp1.entities.Travailler> travaillers = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public String getPrenomEmploye() {
        return prenomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }

    public Integer getAgeEmploye() {
        return ageEmploye;
    }

    public void setAgeEmploye(Integer ageEmploye) {
        this.ageEmploye = ageEmploye;
    }

    public sio.tp1.entities.Statut getNumStatut() {
        return numStatut;
    }

    public void setNumStatut(sio.tp1.entities.Statut numStatut) {
        this.numStatut = numStatut;
    }

    public Set<sio.tp1.entities.Travailler> getTravaillers() {
        return travaillers;
    }

    public void setTravaillers(Set<sio.tp1.entities.Travailler> travaillers) {
        this.travaillers = travaillers;
    }

}