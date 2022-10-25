package dad.calculadorafxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculadoraFXML extends Application {

    private Controller controller;

    @Override
    public void start(Stage stage) throws IOException {
        controller = new Controller();
        Scene scene = new Scene(controller.getView().getParent(), 320, 240);
        stage.setTitle("CalculadoraFXML");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}