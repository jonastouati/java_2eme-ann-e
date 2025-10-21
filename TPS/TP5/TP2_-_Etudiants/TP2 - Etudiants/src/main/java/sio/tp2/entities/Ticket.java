package sio.tp2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tickets", schema = "bddTickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTicket", nullable = false)
    private Integer id;

    @Column(name = "nomTicket", nullable = false, length = 250)
    private String nomTicket;

    @Column(name = "dateTicket", nullable = false)
    private LocalDate dateTicket;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numUser", nullable = false)
    private sio.tp2.entities.User numUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numEtat", nullable = false)
    private Etat numEtat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomTicket() {
        return nomTicket;
    }

    public void setNomTicket(String nomTicket) {
        this.nomTicket = nomTicket;
    }

    public LocalDate getDateTicket() {
        return dateTicket;
    }

    public void setDateTicket(LocalDate dateTicket) {
        this.dateTicket = dateTicket;
    }

    public sio.tp2.entities.User getNumUser() {
        return numUser;
    }

    public void setNumUser(sio.tp2.entities.User numUser) {
        this.numUser = numUser;
    }

    public Etat getNumEtat() {
        return numEtat;
    }

    public void setNumEtat(Etat numEtat) {
        this.numEtat = numEtat;
    }

}