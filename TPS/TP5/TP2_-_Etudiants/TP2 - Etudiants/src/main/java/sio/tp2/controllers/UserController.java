package sio.tp2.controllers;

import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

@Component
public class UserController
{

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
    private TableView tvTickets;

    public void initDatas()
    {
        tcNumeroTicket.setCellValueFactory(new PropertyValueFactory<>("idTicket"));
        tcNomTicket.setCellValueFactory(new PropertyValueFactory<>("nomTicket"));
        tcDateTicket.setCellValueFactory(new PropertyValueFactory<>("dateTicket"));
        tcEtatTicket.setCellValueFactory(new PropertyValueFactory<>("nomEtat"));

        // A vous de jouer
    }

    @javafx.fxml.FXML
    public void btnModifierClicked(Event event)
    {
        // A vous de jouer
    }
}
