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

    public void goBack() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("menu-view.fxml"));
            String menuCSS = Objects.requireNonNull(this.getClass().getResource("/menustyle.css")).toExternalForm();
            Scene scene = backButton.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(menuCSS);
            scene.setRoot(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}