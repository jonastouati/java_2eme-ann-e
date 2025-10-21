package sio.tp2.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "etats", schema = "bddTickets")
public class Etat {
    @Id
    @Column(name = "idEtat", nullable = false)
    private Integer id;

    @Column(name = "nomEtat", nullable = false, length = 50)
    private String nomEtat;

    @OneToMany(mappedBy = "numEtat")
    private Set<sio.tp2.entities.Ticket> tickets = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomEtat() {
        return nomEtat;
    }

    public void setNomEtat(String nomEtat) {
        this.nomEtat = nomEtat;
    }

    public Set<sio.tp2.entities.Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<sio.tp2.entities.Ticket> tickets) {
        this.tickets = tickets;
    }

}