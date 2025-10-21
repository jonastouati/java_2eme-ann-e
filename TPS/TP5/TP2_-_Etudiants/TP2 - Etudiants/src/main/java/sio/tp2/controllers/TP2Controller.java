package sio.tp2.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import sio.tp2.TP2Application;
import sio.tp2.entities.User;
import sio.tp2.repositories.UserRepository;
import sio.tp2.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



@Component
public class TP2Controller implements Initializable
{
    private final UserService userService;
    private final UserController userController;


    @FXML
    private TextField txtLogin;
    @FXML
    private Label txtErreur;
    @FXML
    private PasswordField txtMotDePasse;
    @FXML
    private Button btnConnexion;

    Alert alert;

    public TP2Controller(UserService userService, UserController userController) {
        this.userService = userService;
        this.userController = userController;
    }

    @FXML
    public void btnConnexionClicked(Event event) throws IOException {
        // A vous de jouer
        if (txtLogin.getText().isEmpty())
        {
            txtErreur.setText("Veuillez entrer un identifiant");
        } else if (txtMotDePasse.getText().isEmpty()) {
            txtErreur.setText("Veuillez entrer un mot de passe");
        }
        else if (!txtLogin.getText().equals(txtMotDePasse.getText()))
        {
            txtErreur.setText("Identifiants ou mot de passe incorrect");
        }
        else if (userService.getByLoginAndPwdUser(txtLogin.getText(), txtMotDePasse.getText()) == null)
            {
                txtErreur.setText("Identifiants Incorrect ");
            }
        else if (userService.getByLoginAndPwdUser(txtLogin.getText(),txtMotDePasse.getText()).getStatutUser().equals("admin"))
        {
            FXMLLoader fxmlLoader = new FXMLLoader(TP2Application.class.getResource("admin-view.fxml"));
            fxmlLoader.setControllerFactory(TP2Application.getSpringContext()::getBean);
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Administrateur");
            stage.setScene(scene);
            stage.show();
        }
        else {
            {
                User user = userService.getByLoginAndPwdUser(txtLogin.getText(), txtMotDePasse.getText());
                FXMLLoader fxmlLoader = new FXMLLoader(TP2Application.class.getResource("user-view.fxml"));
                fxmlLoader.setControllerFactory(TP2Application.getSpringContext()::getBean);
                Scene scene = new Scene(fxmlLoader.load());
                UserController userController = fxmlLoader.getController();
                userController.initDatas(user);
                Stage stage = new Stage();
                stage.setTitle("user");
                stage.setScene(scene);
                stage.show();
            }
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}