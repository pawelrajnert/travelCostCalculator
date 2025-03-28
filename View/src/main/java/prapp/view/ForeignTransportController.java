package prapp.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import prapp.FileDao;
import prapp.ForeignTransportation;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ForeignTransportController {
    private ForeignTransportation transportation;
    private final FileDao<ForeignTransportation> fileDao = new FileDao<>(ForeignTransportation.class);

    @FXML
    private Button backButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button costButton;

    @FXML
    private TextField distanceBox;

    @FXML
    private TextField participantsBox;

    @FXML
    private TextField tutorsBox;

    @FXML
    private TextField pilotsBox;

    @FXML
    private TextField driversBox;

    @FXML
    private TextField costBox;

    @FXML
    public void initialize() {
        startLimitation();
    }

    public ForeignTransportation dataLoader() {
        try {
            int km = Integer.parseInt(distanceBox.getText());
            int participants = Integer.parseInt(participantsBox.getText());
            int tutors = Integer.parseInt(tutorsBox.getText());
            int pilots = Integer.parseInt(pilotsBox.getText());
            int drivers = Integer.parseInt(driversBox.getText());

            if (km <= 0 || km > 20000 || participants <= 0 || participants > 46 || tutors <= 0 || tutors > 4 ||
                    pilots <= 0 || pilots > 2 || drivers <= 0 || drivers > 2) {
                showAlert("Błąd podczas wpisywania danych", "Wprowadzono niepoprawne dane");
                return null;
            }

            return new ForeignTransportation(km, participants, tutors, pilots, drivers);
        } catch (Exception e) {
            showAlert("Błąd podczas ładowania danych", "Wystąpił nieoczekiwany błąd: " + e.getMessage());
            return null;
        }
    }

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

    public void saveFT() {
        try {
            transportation = dataLoader();
            if (transportation == null) {
                return;
            }

            transportCost();

            if (transportation != null) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Zapisz dane kalkulacji");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plik kalkulacji .ForeignTransportation", "*.ForeignTransportation"));

                File file = fileChooser.showSaveDialog(new Stage());
                if (file != null) {
                    String fileName = file.getAbsolutePath().replaceAll("\\.ForeignTransportation$", "");
                    fileDao.write(fileName, transportation);
                    showAlert("Poprawnie wprowadzone dane", "Zapisano w pliku: " + fileName + ".ForeignTransportation");
                }
            }
        } catch (NumberFormatException e) {
            showAlert("Błąd podczas zapisu danych", "Wprowadzono wartości nie będące poprawnymi liczbami");
        } catch (IllegalArgumentException e) {
            showAlert("Błąd podczas zapisu danych", e.getMessage());
        } catch (Exception e) {
            showAlert("Błąd podczas zapisu danych", "Wystąpił nieoczekiwany błąd: " + e.getMessage());
        }
    }

    public void loadFT() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wczytaj dane kalkulacji");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plik kalkulacji .ForeignTransportation", "*.ForeignTransportation"));

        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            String fileName = file.getAbsolutePath().replaceAll("\\.ForeignTransportation$", "");
            transportation = fileDao.read(fileName);

            if (transportation != null) {
                distanceBox.setText(String.valueOf(transportation.getKmAmount()));
                participantsBox.setText(String.valueOf(transportation.getParticipantsAmount()));
                tutorsBox.setText(String.valueOf(transportation.getTutorsAmount()));
                pilotsBox.setText(String.valueOf(transportation.getPilotsAmount()));
                driversBox.setText(String.valueOf(transportation.getDriversAmount()));
                transportCost();
                showAlert("Wczytano dane kalkulacji transportu zagranicznego", "Odczytano wartości z pliku: " + fileName + ".ForeignTransportation");
            } else {
                showAlert("Błąd podczas wczytywania danych", "Nie udało się wczytać kalkulacji");
            }
        }
    }

    public void transportCost() {
        try {
            transportation = dataLoader();
            if (transportation == null) {
                return;
            }

            double cost = transportation.calculateTotalCost();
            costBox.setText(String.format(cost + " zł"));

        } catch (NumberFormatException e) {
            showAlert("Błąd podczas wprowadzania danych", "Wprowadzono wartości nie będące poprawnymi liczbami");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void textFieldLimitation(TextField tf, int maxLength) {
        tf.textProperty().addListener((input, oldValue, newValue) -> {
                    if (newValue.length() > maxLength) {
                        tf.setText(newValue.substring(0, maxLength));
                    }
                }
        );
    }

    private void startLimitation() {
        textFieldLimitation(distanceBox, 5);
        textFieldLimitation(participantsBox, 2);
        textFieldLimitation(tutorsBox, 1);
        textFieldLimitation(driversBox, 1);
        textFieldLimitation(pilotsBox, 1);
    }
}