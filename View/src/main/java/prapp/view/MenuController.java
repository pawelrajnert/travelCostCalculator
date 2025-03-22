package prapp.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class MenuController {
    @FXML
    private Button LTrans;
    @FXML
    private Button FTrans;
    @FXML
    private Button LTrip;
    @FXML
    private Button FTrip;
    @FXML
    private Button Info;

    @FXML
    private void clickLTrip() {

    }

    @FXML
    private void clickFTrip() {

    }

    @FXML
    private void clickLTrans() {

    }

    @FXML
    private void clickFTrans() {

    }

    @FXML
    private void clickInfo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("info-view.fxml"));
            String infoCSS = Objects.requireNonNull(this.getClass().getResource("/info.css")).toExternalForm();
            BorderPane infoPane = loader.load();
            InfoController infoController = loader.getController();
            infoController.initialize();
            Scene infoScene = new Scene(infoPane, 650, 450);
            infoScene.getStylesheets().add(infoCSS);
            Stage stage = (Stage) Info.getScene().getWindow();
            stage.setScene(infoScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickExit() {
        Platform.exit();
    }
}