package sio.tp2.dto;

import java.time.LocalDate;

public class TicketUser
{
    private int idTicket;
    private String nomTicket;
    private LocalDate dateTicket;
    private String etatTicket;


    public TicketUser(int idTicket, String nomTicket, LocalDate dateTicket, String etatTicket)
    {
        this.idTicket = idTicket;
        this.nomTicket = nomTicket;
        this.dateTicket = dateTicket;
        this.etatTicket = etatTicket;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public String getNomTicket() {
        return nomTicket;
    }

    public LocalDate getDateTicket() {
        return dateTicket;
    }

    public String getEtatTicket() {
        return etatTicket;
    }
}
