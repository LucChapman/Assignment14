import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage primaryStage) {
        
        Label inputLabel = new Label("Enter value:");
        Label resultLabel = new Label("Converted value:");

        TextField inputField = new TextField();
        TextField resultField = new TextField();
        resultField.setEditable(false);

        ComboBox<String> conversionTypeBox = new ComboBox<>();
        conversionTypeBox.getItems().addAll("oz to g", "lb to kg", "F to C", "mi to km");
        conversionTypeBox.setValue("oz to g");

        Button convertButton = new Button("Convert");

        convertButton.setOnAction(e -> {
            try {
  
                String conversionType = conversionTypeBox.getValue();
                double inputValue = Double.parseDouble(inputField.getText());

                double result = 0;

                switch (conversionType) {
                    case "oz to g":
                        result = inputValue * 28.3495;
                        break;
                    case "lb to kg":
                        result = inputValue * 0.453592; 
                        break;
                    case "F to C":
                        result = (inputValue - 32) * 5 / 9;
                        break;
                    case "mi to km":
                        result = inputValue * 1.60934; 
                        break;
                }

                resultField.setText(String.format("%.2f", result));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input");
            }
        });

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        grid.add(inputLabel, 0, 0);
        grid.add(inputField, 1, 0);
        grid.add(conversionTypeBox, 1, 1);
        grid.add(convertButton, 1, 2);
        grid.add(resultLabel, 0, 3);
        grid.add(resultField, 1, 3);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setTitle("Unit Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
