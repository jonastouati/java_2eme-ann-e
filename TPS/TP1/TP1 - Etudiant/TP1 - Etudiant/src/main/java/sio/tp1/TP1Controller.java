package sio.tp1;

import com.sun.source.tree.Tree;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import sio.tp1.Model.Message;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class TP1Controller implements Initializable {

    @FXML
    private Button cmdEnvoyer;
    @FXML
    private Button cmdRecevoir;
    @FXML
    private AnchorPane apEnvoyer;
    @FXML
    private AnchorPane apRecevoir;
    @FXML
    private Label lblTitre;
    @FXML
    private ListView lstExpediteurs;
    @FXML
    private ListView lstDestinataires;
    @FXML
    private TextField txtMessage;
    @FXML
    private Button cmdEnvoyerMessage;

    private HashMap<String, ArrayList<Message>> maMessagerie;
    @FXML
    private ComboBox cboDestinataires;
    @FXML
    private TreeView tvMessages;

    @FXML
    public void menuClicked(Event event) {
        if(event.getSource() == cmdEnvoyer)
        {
            lblTitre.setText("TP1 : Messagerie / Envoyer");
            apEnvoyer.toFront();
        }
        else//if(event.getSource() == cmdRecevoir)
        {
            lblTitre.setText("TP1 : Messagerie / Recevoir");
            apRecevoir.toFront();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblTitre.setText("TP1 : Messagerie / Envoyer");
        apEnvoyer.toFront();
        lstExpediteurs.getItems().addAll("Enzo","Noa","Lilou","Milo");
        lstDestinataires.getItems().addAll("Enzo","Noa","Lilou","Milo");
        cboDestinataires.getItems().addAll("Enzo","Noa","Lilou","Milo");
        cboDestinataires.getSelectionModel().selectFirst();
        maMessagerie = new HashMap<>();
    }

    @FXML
    public void cmdEnvoyerMessageClicked(Event event)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur de sélection");
        alert.setHeaderText("");

        if(lstExpediteurs.getSelectionModel().getSelectedItem()== null)
        {

            alert.setContentText("Veuillez sélectionner un expéditeur");
            alert.showAndWait();
        } else if (lstDestinataires.getSelectionModel().getSelectedItem()== null)
        {
            alert.setContentText("Veuillez sélectionner un destinataire");
            alert.showAndWait();
        } else if (txtMessage.getText().isEmpty())
        {
            alert.setContentText("Veuillez saisir votre message");
            alert.showAndWait();
        }
        else {
            // tout est ok

            if (!maMessagerie.containsKey(lstDestinataires.getSelectionModel().getSelectedItem().toString()))
            {
                ArrayList<Message> lesMessages = new ArrayList<>();
                maMessagerie.put(lstDestinataires.getSelectionModel().getSelectedItem().toString(), lesMessages);

            }
            Message leMessage =new Message(
                    lstExpediteurs.getSelectionModel().getSelectedItem().toString(),
                    lstDestinataires.getSelectionModel().getSelectedItem().toString(),
                    txtMessage.getText()
            );
            maMessagerie.get(lstDestinataires.getSelectionModel().getSelectedItem().toString()).add(leMessage);









            // Vérifier si la clé existe ou pas
            // Si elle n'existe pas
                // créer la liste des messages ==> Arraylist
                // Créer le message ==> l'objet message à instancier
                // Ajouter le message à la liste des messages
                // Ajouter la clé et la liste à la Hashmap
            // Sinon la clé existe fatalement
                // Créer le message ==> l'objet message à instancier
                // Ajouter le message à la liste des messages

        }

    }

    @FXML
    public void cboDestinatairesClicked(Event event)
    {
        int nb=1;

        TreeItem root = new TreeItem<>("Toues les messages");

        if (maMessagerie.containsKey(cboDestinataires.getSelectionModel().getSelectedItem().toString())) {


            for (Message message : maMessagerie.get(cboDestinataires.getSelectionModel().getSelectedItem().toString())) {
                TreeItem noeudMessage = new TreeItem("Message n° : " + nb);

                TreeItem noeudDestinataire = new TreeItem("De ==> " + message.getExpediteur());
                TreeItem noeudContenu = new TreeItem("Message ==> " + message.getContenuDuMessage());

                noeudMessage.getChildren().add(noeudDestinataire);
                noeudMessage.getChildren().add(noeudContenu);
                noeudMessage.setExpanded(true);

                root.getChildren().add(noeudMessage);


                nb++;
            }
        }
        else {
            TreeItem noeudPasDeMessage = new TreeItem("Pas de message");
            root.getChildren().add(noeudPasDeMessage);
        }
        tvMessages.setRoot(root);
    root.setExpanded(true);



    }
}