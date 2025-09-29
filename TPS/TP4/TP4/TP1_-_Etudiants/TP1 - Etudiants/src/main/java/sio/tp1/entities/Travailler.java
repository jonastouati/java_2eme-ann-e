package sio.tp1.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "travailler")
public class Travailler {
    @EmbeddedId
    private TravaillerId id;

    @MapsId("codeEmploye")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codeEmploye", nullable = false)
    private Employe codeEmploye;

    @MapsId("codeRayon")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codeRayon", nullable = false)
    private Rayon codeRayon;

    @Column(name = "temps")
    private Integer temps;

    public TravaillerId getId() {
        return id;
    }

    public void setId(TravaillerId id) {
        this.id = id;
    }

    public Employe getCodeEmploye() {
        return codeEmploye;
    }

    public void setCodeEmploye(Employe codeEmploye) {
        this.codeEmploye = codeEmploye;
    }

    public Rayon getCodeRayon() {
        return codeRayon;
    }

    public void setCodeRayon(Rayon codeRayon) {
        this.codeRayon = codeRayon;
    }

    public Integer getTemps() {
        return temps;
    }

    public void setTemps(Integer temps) {
        this.temps = temps;
    }

}