package sio.tp1.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;
import sio.tp1.entities.Employe;
import sio.tp1.entities.Rayon;
import sio.tp1.entities.Secteur;
import sio.tp1.services.EmployeService;
import sio.tp1.services.RayonService;
import sio.tp1.services.SecteursService;
import sio.tp1.services.TravaillerService;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Component
public class TP1Controller implements Initializable {

    private final RayonService rayonService;
    private final TravaillerService travaillerService;
    Alert alert;
    EmployeService employeService;
    SecteursService secteursService;
    TravaillerService travService;

    @FXML
    private TableColumn tcNomSecteur;
    @FXML
    private TableView<Rayon> tvRayons;
    @FXML
    private TableView tvEmployesRayon;
    @FXML
    private TableColumn tcNumeroEmployeAll;
    @FXML
    private TableView<Employe> tvEmployesAll;
    @FXML
    private TableColumn tcDateEmployeRayon;
    @FXML
    private TableColumn tcNumeroRayon;
    @FXML
    private TableColumn tcNumeroEmployeRayon;
    @FXML
    private TableColumn tcNomRayon;
    @FXML
    private TableView<Secteur> tvSecteurs;
    @FXML
    private TableColumn tcNomEmployeAll;
    @FXML
    private TableColumn tcNomEmployeRayon;
    @FXML
    private TableColumn tcHeureEmployeRayon;
    @FXML
    private TableColumn tcNumeroSecteur;
    @FXML
    private Button btnAjouter;
    @FXML
    private DatePicker dpDate;
    @FXML
    private TextField txtNbHeures;
    @FXML
    private TextField txtTotalRayon;
    @FXML
    private TextField txtTotalSecteur;


    public TP1Controller(EmployeService employeService, SecteursService secteursService, RayonService rayonService, TravaillerService travaillerService) {
        this.employeService = employeService;
        this.secteursService = secteursService;
        this.rayonService = rayonService;
        this.travaillerService = travaillerService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Choix incorrect");
        alert.setHeaderText(null);

        tcNumeroSecteur.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomSecteur.setCellValueFactory(new PropertyValueFactory<>("nomSecteur"));

        tcNumeroRayon.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomRayon.setCellValueFactory(new PropertyValueFactory<>("nomRayon"));

        tcNumeroEmployeRayon.setCellValueFactory(new PropertyValueFactory<>("idEmploye"));
        tcNomEmployeRayon.setCellValueFactory(new PropertyValueFactory<>("nomEmploye"));
        tcDateEmployeRayon.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcHeureEmployeRayon.setCellValueFactory(new PropertyValueFactory<>("temps"));

        tcNumeroEmployeAll.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomEmployeAll.setCellValueFactory(new PropertyValueFactory<>("nomEmploye"));

        tvEmployesAll.setItems(FXCollections.observableList(employeService.getAllEmploye()));
        tvSecteurs.setItems(FXCollections.observableList(secteursService.getAllSecteurs()));
    }

    @FXML
    public void tvSecteursClicked(Event event) {
        tvRayons.setItems(FXCollections.observableList(rayonService.getAllRayonByIdSecteur((Secteur) tvSecteurs.getSelectionModel().getSelectedItem())));
        txtTotalSecteur.setText(String.valueOf(travaillerService.getTotalHeuresSecteur(((Secteur) tvSecteurs.getSelectionModel().getSelectedItem()).getId())));
    }

    @FXML
    public void tvRayonsClicked(Event event) {
        tvEmployesRayon.setItems(FXCollections.observableList(travaillerService.getAllEmployesRayon(tvRayons.getSelectionModel().getSelectedItem().getId())));
        txtTotalRayon.setText(String.valueOf(travaillerService.getTotalHeureseTemps(tvRayons.getSelectionModel().getSelectedItem().getId())));
    }

    @FXML
    public void btnAjouterAction(ActionEvent actionEvent) {
        if (tvRayons.getSelectionModel().getSelectedItem()==null)
        {
            alert.setContentText("Choisir un rayon");
            alert.showAndWait();
        } else if (tvEmployesAll.getSelectionModel().getSelectedItem()== null)
        {
            alert.setContentText("Choisir un employé");
            alert.showAndWait();
        } else if (dpDate.getValue()== null)
        {
            alert.setContentText("Choisir une date");
            alert.showAndWait();
        } else if (txtNbHeures.getText().isEmpty())
        {
            alert.setContentText("Saisir un nombre d'heures");
            alert.showAndWait();
        } else if (verifierDejaTravailler(tvEmployesAll.getSelectionModel().getSelectedItem(),dpDate.getValue())!=0)
        {
            alert.setContentText("Déjà travaillé");
            alert.showAndWait();
        }
        else
        {
            travaillerService.insererNouveauTemps
                    (
                            tvEmployesAll.getSelectionModel().getSelectedItem(),
                            tvRayons.getSelectionModel().getSelectedItem(),
                            dpDate.getValue(),
                            Integer.parseInt(txtNbHeures.getText())
                    );
            txtTotalRayon.setText(String.valueOf(travaillerService.getTotalHeureseTemps(tvRayons.getSelectionModel().getSelectedItem().getId())));
            txtTotalSecteur.setText(String.valueOf(travaillerService.getTotalHeuresSecteur(
                    tvSecteurs.getSelectionModel().getSelectedItem().getId() )));
            tvEmployesRayon.setItems(FXCollections.observableList(travaillerService.getAllEmployesRayon
                    (tvRayons.getSelectionModel().getSelectedItem().getId())));
        }

    }
    public long verifierDejaTravailler(Employe unEmploye, LocalDate uneDate)
    {
        return travaillerService.dejaTravailler(unEmploye,uneDate);
    }
}