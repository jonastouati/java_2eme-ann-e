package sio.tp1.entities;

//import javax.persistence.*;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "rayon")
public class Rayon {
    @Id
    @Column(name = "idRayon", nullable = false)
    private Integer id;

    @Column(name = "nomRayon", nullable = false, length = 20)
    private String nomRayon;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numSecteur", nullable = false)
    private Secteur numSecteur;

    @OneToMany(mappedBy = "codeRayon")
    private Set<Travailler> travaillers = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomRayon() {
        return nomRayon;
    }

    public void setNomRayon(String nomRayon) {
        this.nomRayon = nomRayon;
    }

    public sio.tp1.entities.Secteur getNumSecteur() {
        return numSecteur;
    }

    public void setNumSecteur(sio.tp1.entities.Secteur numSecteur) {
        this.numSecteur = numSecteur;
    }

    public Set<sio.tp1.entities.Travailler> getTravaillers() {
        return travaillers;
    }

    public void setTravaillers(Set<sio.tp1.entities.Travailler> travaillers) {
        this.travaillers = travaillers;
    }

}