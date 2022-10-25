package dad.calculadorafxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class View {

    private Parent parent;

    public View() {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculadoraFXML.class.getResource("calculadora.fxml"));
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Parent getParent() {
        return parent;
    }
}
