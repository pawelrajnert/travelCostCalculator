package prapp.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import prapp.LocalTrip;

import java.io.*;

import prapp.FileDao;

import java.util.Objects;

public class LocalTripController {
    private LocalTrip trip;
    private final FileDao<LocalTrip> fileDao = new FileDao<>(LocalTrip.class);

    @FXML
    private Button backButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button costButton;


    public void goBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu-view.fxml"));
            String menuCSS = Objects.requireNonNull(this.getClass().getResource("/menustyle.css")).toExternalForm();
            BorderPane menuPane = loader.load();
            Scene menuScene = new Scene(menuPane, 700, 500);
            menuScene.getStylesheets().add(menuCSS);
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(menuScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
