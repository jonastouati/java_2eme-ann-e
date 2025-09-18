package sio.tp3;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sio.tp3.Model.Tache;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class TP3Controller implements Initializable {
    private HashMap<String, HashMap<String, ArrayList<Tache>>> mesTaches;
    private TreeItem<String> racine;

    @FXML
    private ListView<String> lstThemes;
    @FXML
    private ListView<String> lstProjets;
    @FXML
    private TreeView<String> tvTaches;
    @FXML
    private ComboBox<String> cboDeveloppeurs;
    @FXML
    private Button cmdValider;
    @FXML
    private TextField txtNomTache;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mesTaches = new HashMap<>();
        racine = new TreeItem<>("Mes tâches");
        racine.setExpanded(true);
        tvTaches.setRoot(racine);

        cboDeveloppeurs.getItems().addAll("Enzo", "Noa", "Lilou", "Milo");
        cboDeveloppeurs.getSelectionModel().selectFirst();

        lstThemes.getItems().addAll("Mobile", "Web", "Réseau");

        for (int i = 1; i <= 10; i++) {
            lstProjets.getItems().add("Projet n°" + i);
        }
    }

    @FXML
    public void cmdValiderClicked(Event event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("");

        String theme = lstThemes.getSelectionModel().getSelectedItem();
        String projet = lstProjets.getSelectionModel().getSelectedItem();
        String nomTache = txtNomTache.getText();
        String developpeur = cboDeveloppeurs.getSelectionModel().getSelectedItem();

        if (nomTache == null || nomTache.isEmpty()) {
            alert.setContentText("Veuillez saisir une tâche");
            alert.showAndWait();

        }
        if (theme == null) {
            alert.setContentText("Veuillez sélectionner un thème");
            alert.showAndWait();

        }
        if (projet == null) {
            alert.setContentText("Veuillez sélectionner un projet");
            alert.showAndWait();

        }

        Tache tache = new Tache(nomTache, developpeur, false);

        mesTaches.putIfAbsent(theme, new HashMap<>());
        mesTaches.get(theme).putIfAbsent(projet, new ArrayList<>());
        mesTaches.get(theme).get(projet).add(tache);

        TreeItem<String> themeNoeud = racine.getChildren().stream()
                .filter(item -> item.getValue().equals(theme))
                .findFirst()
                .orElse(null);

        if (themeNoeud == null) {
            themeNoeud = new TreeItem<>(theme);
            themeNoeud.setExpanded(true);
            racine.getChildren().add(themeNoeud);
        }

        TreeItem<String> projetNoeud = themeNoeud.getChildren().stream()
                .filter(item -> item.getValue().equals(projet))
                .findFirst()
                .orElse(null);

        if (projetNoeud == null) {
            projetNoeud = new TreeItem<>(projet);
            projetNoeud.setExpanded(true);
            themeNoeud.getChildren().add(projetNoeud);
        }


        TreeItem<String> tacheNoeud = new TreeItem<>(tache.getNomTache() + " (" + tache.getNomDeveloppeur() + ") ⬜");
        projetNoeud.getChildren().add(tacheNoeud);

        txtNomTache.clear();
    }

    @FXML
    public void tvTachesClicked(Event event) {
    }
}
