package sio.tp2.controllers;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;
import sio.tp2.entities.Ticket;
import sio.tp2.entities.User;
import sio.tp2.repositories.UserRepository;
import sio.tp2.services.TicketService;
import sio.tp2.services.UserService;

import java.net.URL;
import java.util.ResourceBundle;
@Component
public class AdminController implements Initializable {
    private final UserService userService;
    private final TicketService ticketService;
    @javafx.fxml.FXML
    private TableColumn tcNomTicket;
    @javafx.fxml.FXML
    private TableColumn tcDateTicket;
    @javafx.fxml.FXML
    private TextField txtNomTicket;
    @javafx.fxml.FXML
    private ComboBox cboEtats;
    @javafx.fxml.FXML
    private TableView<User> tvUsers;
    @javafx.fxml.FXML
    private TableColumn tcNomUser;
    @javafx.fxml.FXML
    private TableColumn tcNumeroTicket;
    @javafx.fxml.FXML
    private TableColumn tcEtatTicket;
    @javafx.fxml.FXML
    private Button btnInserer;
    @javafx.fxml.FXML
    private TableColumn tcNumeroUser;
    @javafx.fxml.FXML
    private TableView <Ticket>tvTickets;

    public AdminController(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }


    @javafx.fxml.FXML
    public void tvUsersClicked(Event event)
    {
        // A vous de jouer
        User user = tvUsers.getSelectionModel().getSelectedItem();
        tvTickets.setItems(FXCollections.observableList(this.ticketService.getTicketsByUser(user)));


    }

    @javafx.fxml.FXML
    public void btnInsererClicked(Event event) {
        // A vous de jouer
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcNumeroUser.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomUser.setCellValueFactory(new PropertyValueFactory<>("nomUser"));
        tcNumeroTicket.setCellValueFactory(new PropertyValueFactory<>("idTicket"));
        tcNomTicket.setCellValueFactory(new PropertyValueFactory<>("nomTicket"));
        tcDateTicket.setCellValueFactory(new PropertyValueFactory<>("dateTicket"));
        tcEtatTicket.setCellValueFactory(new PropertyValueFactory<>("nomEtat"));

        // A vous de jouer
        tvUsers.setItems(FXCollections.observableArrayList(userService.findAll()));

    }
}

