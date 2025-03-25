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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("local-transport-view.fxml"));
            String ltransCSS = Objects.requireNonNull(this.getClass().getResource("/transportstyle.css")).toExternalForm();
            BorderPane ltransPane = loader.load();
            Scene ltransScene = new Scene(ltransPane, 700, 500);
            ltransScene.getStylesheets().add(ltransCSS);
            Stage stage = (Stage) LTrans.getScene().getWindow();
            stage.setScene(ltransScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickFTrans() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("foreign-transport-view.fxml"));
            String ftransCSS = Objects.requireNonNull(this.getClass().getResource("/transportstyle.css")).toExternalForm();
            BorderPane ftransPane = loader.load();
            Scene ftransScene = new Scene(ftransPane, 700, 500);
            ftransScene.getStylesheets().add(ftransCSS);
            Stage stage = (Stage) FTrans.getScene().getWindow();
            stage.setScene(ftransScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickInfo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("info-view.fxml"));
            String infoCSS = Objects.requireNonNull(this.getClass().getResource("/info.css")).toExternalForm();
            BorderPane infoPane = loader.load();
            InfoController infoController = loader.getController();
            infoController.initialize();
            Scene infoScene = new Scene(infoPane, 700, 500);
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