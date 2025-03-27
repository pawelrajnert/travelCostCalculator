package prapp.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Parent;

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
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("local-trip-view.fxml"));
            String ltripCSS = Objects.requireNonNull(this.getClass().getResource("/tripstyle.css")).toExternalForm();
            Scene scene = LTrip.getScene();
            scene.getStylesheets().add(ltripCSS);
            scene.setRoot(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickFTrip() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("foreign-trip-view.fxml"));
            String ftripCSS = Objects.requireNonNull(this.getClass().getResource("/tripstyle.css")).toExternalForm();
            Scene scene = FTrip.getScene();
            scene.getStylesheets().add(ftripCSS);
            scene.setRoot(parent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickLTrans() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("local-transport-view.fxml"));
            String ltransCSS = Objects.requireNonNull(this.getClass().getResource("/transportstyle.css")).toExternalForm();
            Scene scene = LTrans.getScene();
            scene.getStylesheets().add(ltransCSS);
            scene.setRoot(parent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickFTrans() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("foreign-transport-view.fxml"));
            String ftransCSS = Objects.requireNonNull(this.getClass().getResource("/transportstyle.css")).toExternalForm();
            Scene scene = FTrans.getScene();
            scene.getStylesheets().add(ftransCSS);
            scene.setRoot(parent);

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