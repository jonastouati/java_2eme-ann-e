package sio.tp1.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "statut")
public class Statut {
    @Id
    @Column(name = "idStatut", nullable = false)
    private Integer id;

    @Column(name = "nomStatut", nullable = false, length = 20)
    private String nomStatut;

    @OneToMany(mappedBy = "numStatut")
    private Set<Employe> employes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomStatut() {
        return nomStatut;
    }

    public void setNomStatut(String nomStatut) {
        this.nomStatut = nomStatut;
    }

    public Set<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(Set<Employe> employes) {
        this.employes = employes;
    }

}