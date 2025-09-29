package sio.tp1.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "secteur")
public class Secteur {
    @Id
    @Column(name = "idSecteur", nullable = false)
    private Integer id;

    @Column(name = "nomSecteur", nullable = false, length = 20)
    private String nomSecteur;

    @OneToMany(mappedBy = "numSecteur")
    private Set<Rayon> rayons = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomSecteur() {
        return nomSecteur;
    }

    public void setNomSecteur(String nomSecteur) {
        this.nomSecteur = nomSecteur;
    }

    public Set<Rayon> getRayons() {
        return rayons;
    }

    public void setRayons(Set<Rayon> rayons) {
        this.rayons = rayons;
    }

}