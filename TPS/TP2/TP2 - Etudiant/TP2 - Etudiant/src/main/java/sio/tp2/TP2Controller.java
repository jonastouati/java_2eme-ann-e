package sio.tp2;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sio.tp2.Model.RendezVous;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class TP2Controller implements Initializable {

    private TreeMap<String, TreeMap<String, RendezVous>> monPlanning;
    private TreeMap<String,RendezVous>monRendezVous;
    TreeItem root;
    @FXML
    private TextField txtNomPatient;
    @FXML
    private ComboBox cboNomPathologie;
    @FXML
    private TreeView tvPlanning;
    @FXML
    private DatePicker dpDateRdv;
    @FXML
    private Spinner spHeure;
    @FXML
    private Spinner spMinute;
    @FXML
    private Button cmdValider;

    @FXML
    public void cmdValiderClicked(Event event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur de saisie ");
        alert.setHeaderText(null);
        if (txtNomPatient.getText().isEmpty()) {
            alert.setContentText("veuillez saisie le nom du patient ");
            alert.showAndWait();
        } else if (dpDateRdv.getValue() == null) {

            alert.setContentText("veuillez choisir une date ");
            alert.showAndWait();

        } else {
            String heureChoisie ="";
            String minuteChoisie = "";

            heureChoisie = spHeure.getValue().toString();
            if (spHeure.getValue().toString().length()==1)
            {
                minuteChoisie=spMinute.getValue().toString() + "0";
            }
            String heureRdv = heureChoisie + ":" + minuteChoisie;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dateRdv = dtf.format(dpDateRdv.getValue());

            if (RechercherRDV(dateRdv, heureRdv))
            {
                alert.setContentText(" il existe déjà un rdv a cette heure et cette date ");
            }
            else {
                RendezVous rdv = new RendezVous(heureRdv,txtNomPatient.getText(),cboNomPathologie.getValue().toString());
                if (!monPlanning.containsKey(dateRdv))
                {
                    TreeMap<String,RendezVous> lesRdv = new TreeMap<>();
                    monPlanning.put(dateRdv, lesRdv);
                }
                monPlanning.get(dateRdv).put(heureRdv,rdv);


                TreeItem noeudDate = null;
                TreeItem noeudHeure = null;
                TreeItem noeudRdv = null;

                root.getChildren().clear();

                for (String dte : monPlanning.keySet()) {
                    noeudDate = new TreeItem(dte);
                    noeudDate.setExpanded(true);

                    for (String heure : monPlanning.get(dte).keySet()) {
                        noeudHeure = new TreeItem(heure);
                        noeudHeure.setExpanded(true);
                        noeudRdv = new TreeItem(monPlanning.get(dte).get(heure).getNomPatient());
                        noeudHeure.getChildren().add(noeudRdv);
                        noeudRdv = new TreeItem(monPlanning.get(dte).get(heure).getNomPathologie());
                        noeudHeure.getChildren().add(noeudRdv);
                        noeudDate.getChildren().add(noeudHeure);
                    }
                    root.getChildren().add(noeudDate);
                }
                root.setExpanded(true);
                tvPlanning.setRoot(root);
            }
        }
            // tout est ok

//            if (!monPlanning.containsKey(dpDateRdv.getValue().toString())) {
//                TreeMap<String, RendezVous> monRendezVous = new TreeMap<>();
//                monPlanning.put(dpDateRdv.getValue().toString(), monRendezVous);
//
//            } else if (!monRendezVous.containsKey(dpDateRdv.getValue().toString())) {
//                {
//                    RendezVous mesRDV = new RendezVous
//                            (
//                                    spHeure.toString(),
//                                    txtNomPatient.getText(),
//                                    cboNomPathologie.toString()
//
//                    );
//                    monRendezVous.put(spHeure.getValue().toString(), mesRDV);
//
//                    String nomPatient = txtNomPatient.getText();
//                    String pathologie = cboNomPathologie.getValue().toString();
//                    String dateRDV = dpDateRdv.getValue().toString();
//                    String heure = String.format("0%2d:%02d", spMinute.getValue(), spHeure.getValue());
//
//                    RendezVous RDV = new RendezVous(nomPatient,pathologie,heure);
//                    TreeItem root = new TreeItem("Tous les RendezVous ");
//                    monPlanning.put(dpDateRdv.getValue().toString(), monRendezVous);
//
//                    root.getChildren().clear();
//
//                    for (String date : monPlanning.keySet())
//
//                    {
//
//                        TreeItem noeudDate =new TreeItem(dpDateRdv.getValue().toString());
//                        TreeMap<String, RendezVous> rendezvous =monPlanning.get(date);
//                        TreeItem noeudHeure =new TreeItem(spHeure.toString());
//                        TreeItem noeudPathologie = new TreeItem(cboNomPathologie.getValue().toString());
//                        TreeItem noeudNom =new TreeItem(txtNomPatient.getText().toString());
//
//                        noeudPathologie.getChildren().add(noeudNom);
//                        noeudDate.getChildren().add(noeudHeure);
//                        noeudHeure.getChildren().add(noeudDate);
//                        noeudNom.getChildren().add(noeudHeure);
//                        noeudHeure.getChildren().add(root);
//
//                    }
//                }
//                tvPlanning.setRoot(root);
//
//            }
//        }
    }

public boolean RechercherRDV(String dateRdv, String heureRdv)
{
    boolean trouve = false;
    if(monPlanning.containsKey(dateRdv)) {
        if (monPlanning.get(dateRdv).containsKey(heureRdv)) {
            trouve = true;

        }
    }
return trouve;
}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monPlanning = new TreeMap<>();
        root = new TreeItem("Mon planning");
        tvPlanning.setRoot(root);
        cboNomPathologie.getItems().addAll("Angine","Grippe","Covid","Gastro");
        cboNomPathologie.getSelectionModel().selectFirst();
        SpinnerValueFactory spinnerValueFactoryHeure = new SpinnerValueFactory.IntegerSpinnerValueFactory(8,19,8,1);
        spHeure.setValueFactory(spinnerValueFactoryHeure);
        SpinnerValueFactory spinnerValueFactoryMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,45,0,15);
        spMinute.setValueFactory(spinnerValueFactoryMinute);
    }
}