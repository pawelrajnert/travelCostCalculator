package prapp.view;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class InfoController {

    @FXML
    private TextArea infoBox;

    @FXML
    private Button backButton;

    public void initialize() {
        showInfo();
    }

    public void showInfo() {
        String name = "info.txt";
        StringBuilder display = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
            String text;
            while ((text = reader.readLine()) != null) {
                display.append(text).append("\n");
            }
        } catch (IOException e) {
            display.append("Błąd odczytu informacji o programie.");
            e.printStackTrace();
        }
        infoBox.setText(display.toString());
    }

    public void goBack() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("menu-view.fxml"));
            String menuCSS = Objects.requireNonNull(this.getClass().getResource("/menustyle.css")).toExternalForm();
            Scene scene = backButton.getScene();
            scene.getStylesheets().add(menuCSS);
            scene.setRoot(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}