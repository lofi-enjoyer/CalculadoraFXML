package dad.calculadorafxml;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    private Calculadora model;

    private Map<String, Runnable> actions;

    private View view;

    public Controller() {
        view = new View();

        model = new Calculadora();

        actions = new HashMap<>();
        actions.put(".", model::insertarComa);
        actions.put("+", () -> model.operar(Calculadora.SUMAR));
        actions.put("-", () -> model.operar(Calculadora.RESTAR));
        actions.put("*", () -> model.operar(Calculadora.MULTIPLICAR));
        actions.put("/", () -> model.operar(Calculadora.DIVIDIR));
        actions.put("=", () -> model.operar(Calculadora.IGUAL));
        actions.put("C", model::borrar);
        actions.put("CE", model::borrarTodo);

        view.getParent().getChildrenUnmodifiable().forEach(node -> {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setOnAction(this::onButtonClick);
            } else if (node instanceof TextField) {
                TextField textField = (TextField) node;
                textField.textProperty().bind(model.getPantalla());
            }
        });
    }

    protected void onButtonClick(ActionEvent event) {
        String input = ((Button) event.getSource()).getText();

        Runnable action = actions.get(input);
        if (action != null) {
            action.run();
        } else {
            model.insertar(input.charAt(0));
        }
        System.out.println(model.getPantalla());
    }

    public View getView() {
        return view;
    }

}
