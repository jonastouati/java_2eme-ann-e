package sio.tp2.controllers;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;
import sio.tp2.entities.Ticket;
import sio.tp2.entities.User;
import sio.tp2.services.EtatService;
import sio.tp2.services.TicketService;

@Component
public class UserController
{
    private TicketService ticketService;
    private EtatService etatService;
    private User user;

    public UserController(TicketService ticketService, EtatService etatService) {
        this.ticketService = ticketService;
        this.etatService = etatService;

    }

    @javafx.fxml.FXML
    private TableColumn tcNomTicket;
    @javafx.fxml.FXML
    private TableColumn tcDateTicket;
    @javafx.fxml.FXML
    private ComboBox cboEtats;
    @javafx.fxml.FXML
    private Button btnModifier;
    @javafx.fxml.FXML
    private TableColumn tcNumeroTicket;
    @javafx.fxml.FXML
    private TableColumn tcEtatTicket;
    @javafx.fxml.FXML
    private TableView <Ticket> tvTickets;

    public void initDatas(User leUser)
    {
        user = leUser;

        tcNumeroTicket.setCellValueFactory(new PropertyValueFactory<>("idTicket"));
        tcNomTicket.setCellValueFactory(new PropertyValueFactory<>("nomTicket"));
        tcDateTicket.setCellValueFactory(new PropertyValueFactory<>("dateTicket"));
        tcEtatTicket.setCellValueFactory(new PropertyValueFactory<>("nomEtat"));

        // A vous de jouer
        tvTickets.setItems(FXCollections.observableList(ticketService.findAll()));
        cboEtats.setItems(FXCollections.observableList(etatService.getAllNomsEtats()));
    }



    @javafx.fxml.FXML
    public void btnModifierClicked(Event event)
    {
        // A vous de jouer
        ticketService.modifierTicket
                (
                        tvTickets.getSelectionModel().getSelectedItem(),
                        cboEtats.getSelectionModel().getSelectedItem().toString()
                );
        tvTickets.setItems(FXCollections.observableList(ticketService.findAll()));
    }
}
