package sio.tp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class TP1Application extends Application {


    private ConfigurableApplicationContext springContext;

    @Override
    public void init()
    {
        springContext = SpringApplication.run(TP1Application.class);
    }



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TP1Application.class.getResource("tp1-view.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TP1");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop()
    {
        springContext.close();
    }

    public static void main(String[] args) {
        launch();
    }
}