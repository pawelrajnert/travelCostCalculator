package prapp.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.*;

import prapp.FileDao;
import prapp.LocalTrip;

import java.util.ArrayList;
import java.util.Objects;

public class LocalTripController {
    private LocalTrip trip;
    private final FileDao<LocalTrip> fileDao = new FileDao<>(LocalTrip.class);

    @FXML
    private TextField distanceBox;

    @FXML
    private TextField participantsBox;

    @FXML
    private TextField tutorsBox;

    @FXML
    private TextField tutorsWageBox;

    @FXML
    private TextField pilotsBox;

    @FXML
    private TextField pilotsWageBox;

    @FXML
    private TextField driversBox;

    @FXML
    private TextField costBox;

    @FXML
    private TextField costPerPersonBox;

    @FXML
    private TextField accomodationAmount;

    @FXML
    private VBox accomodationArray;

    @FXML
    private TextField foodAmount;

    @FXML
    private VBox foodArray;

    @FXML
    private TextField guideAmount;

    @FXML
    private VBox guideArray;

    @FXML
    private TextField entranceAmount;

    @FXML
    private VBox entranceArray;

    @FXML
    private TextField insuranceBox;

    @FXML
    private TextField marginBox;

    @FXML
    private TextField discountBox;

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
            Parent parent = FXMLLoader.load(getClass().getResource("menu-view.fxml"));
            String menuCSS = Objects.requireNonNull(this.getClass().getResource("/menustyle.css")).toExternalForm();
            Scene scene = backButton.getScene();
            scene.getStylesheets().add(menuCSS);
            scene.setRoot(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void saveLT() {
        try {
            int km = Integer.parseInt(distanceBox.getText());
            int participants = Integer.parseInt(participantsBox.getText());
            int tutors = Integer.parseInt(tutorsBox.getText());
            int pilots = Integer.parseInt(pilotsBox.getText());
            int drivers = Integer.parseInt(driversBox.getText());

            int acoAmount = Integer.parseInt(accomodationAmount.getText());
            ArrayList<Double> accommodationCost = costsFromArray(getTextFromVBox(accomodationArray));

            int fdAmount = Integer.parseInt(foodAmount.getText());
            ArrayList<Double> foodCost = costsFromArray(getTextFromVBox(foodArray));

            double tutorWage = Double.parseDouble(tutorsWageBox.getText());
            double pilotWage = Double.parseDouble(pilotsWageBox.getText());
            double insuranceCost = Double.parseDouble(insuranceBox.getText());

            int gdAmount = Integer.parseInt(guideAmount.getText());
            ArrayList<Double> guideCost = costsFromArray(getTextFromVBox(guideArray));

            int entrAmount = Integer.parseInt(entranceAmount.getText());
            ArrayList<Double> entranceFees = costsFromArray(getTextFromVBox(entranceArray));

            double margin = Double.parseDouble(marginBox.getText());
            double discount = Double.parseDouble(discountBox.getText());

            trip = new LocalTrip(km, participants, tutors, pilots, drivers, acoAmount, accommodationCost,
                    fdAmount, foodCost, tutorWage, pilotWage, insuranceCost, gdAmount, guideCost, entrAmount, entranceFees, margin, discount);

            tripCost();


            if (trip != null) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Zapisz dane kalkulacji");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plik kalkulacji .LocalTrip", "*.LocalTrip"));

                File file = fileChooser.showSaveDialog(new Stage());
                if (file != null) {
                    String fileName = file.getAbsolutePath().replaceAll("\\.LocalTrip$", "");
                    fileDao.write(fileName, trip);
                    showAlert("Poprawnie wprowadzone dane", "Zapisano w pliku: " + fileName + ".LocalTrip");
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


    public void loadLT() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wczytaj dane kalkulacji");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plik kalkulacji .LocalTrip", "*.LocalTrip"));

        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            String fileName = file.getAbsolutePath().replaceAll("\\.LocalTrip", "");
            trip = fileDao.read(fileName);

            if (trip != null) {
                distanceBox.setText(String.valueOf(trip.getKilometers()));
                participantsBox.setText(String.valueOf(trip.getParticipantsAmount()));
                tutorsBox.setText(String.valueOf(trip.getTutorsAmount()));
                tutorsWageBox.setText(bugFixer(trip.getTutorWage()));
                pilotsBox.setText(String.valueOf(trip.getPilotsAmount()));
                pilotsWageBox.setText(bugFixer(trip.getPilotWage()));
                driversBox.setText(String.valueOf(trip.getDriversAmount()));
                accomodationAmount.setText(String.valueOf(trip.getAccommodationAmount()));
                foodAmount.setText(String.valueOf(trip.getFoodAmount()));
                guideAmount.setText(String.valueOf(trip.getGuideAmount()));
                entranceAmount.setText(String.valueOf(trip.getEntranceAmount()));
                insuranceBox.setText(bugFixer(trip.getInsuranceCost()));
                marginBox.setText(bugFixer(trip.getMargin()));
                discountBox.setText(bugFixer(trip.getDiscount()));
                loadDataFromFile(accomodationArray, trip.getAccommodationCost());
                loadDataFromFile(foodArray, trip.getFoodCost());
                loadDataFromFile(guideArray, trip.getGuideCost());
                loadDataFromFile(entranceArray, trip.getEntranceFees());

                tripCost();
                showAlert("Wczytano dane kalkulacji wycieczki lokalnej", "Odczytano wartości z pliku: " + fileName + ".LocalTrip");
            } else {
                showAlert("Błąd podczas wczytywania danych", "Nie udało się wczytać kalkulacji");
            }
        }
    }

    public void tripCost() {
        try {
            int km = Integer.parseInt(distanceBox.getText());
            int participants = Integer.parseInt(participantsBox.getText());
            int tutors = Integer.parseInt(tutorsBox.getText());
            int pilots = Integer.parseInt(pilotsBox.getText());
            int drivers = Integer.parseInt(driversBox.getText());

            int acoAmount = Integer.parseInt(accomodationAmount.getText());
            ArrayList<Double> accommodationCost = costsFromArray(getTextFromVBox(accomodationArray));

            int fdAmount = Integer.parseInt(foodAmount.getText());
            ArrayList<Double> foodCost = costsFromArray(getTextFromVBox(foodArray));

            double tutorWage = Double.parseDouble(tutorsWageBox.getText());
            double pilotWage = Double.parseDouble(pilotsWageBox.getText());
            double insuranceCost = Double.parseDouble(insuranceBox.getText());

            int gdAmount = Integer.parseInt(guideAmount.getText());
            ArrayList<Double> guideCost = costsFromArray(getTextFromVBox(guideArray));

            int entrAmount = Integer.parseInt(entranceAmount.getText());
            ArrayList<Double> entranceFees = costsFromArray(getTextFromVBox(entranceArray));

            double margin = Double.parseDouble(marginBox.getText());
            double discount = Double.parseDouble(discountBox.getText());

            trip = new LocalTrip(km, participants, tutors, pilots, drivers, acoAmount, accommodationCost,
                    fdAmount, foodCost, tutorWage, pilotWage, insuranceCost, gdAmount, guideCost, entrAmount, entranceFees, margin, discount);

            double cost = trip.calculateTotalCost();
            costBox.setText(String.format(cost + " zł"));

            double costPP = trip.calculateCostPerPerson();
            costPerPersonBox.setText(String.format(costPP + " zł"));

        } catch (NumberFormatException e) {
            showAlert("Błąd podczas obliczania kwoty", "Nie udało się obliczyć kwoty kalkulacji.");
        } catch (Exception e) {
            showAlert("Błąd podczas obliczania kwoty", "Wystąpił nieoczekiwany błąd: " + e.getMessage());
        }
    }


    public void accomodationInsert() {
        accomodationArray.getChildren().clear();
        try {
            int count = Integer.parseInt(accomodationAmount.getText());
            for (int i = 0; i < count; i++) {
                TextField data = new TextField();
                data.setPromptText("Wprowadź koszt noclegu " + (i + 1) + " w PLN");
                accomodationArray.getChildren().add(data);
            }
        } catch (NumberFormatException e) {
            showAlert("Błąd podczas wprowadzania danych", "Podaj poprawną liczbę noclegów");
        }
    }

    public void foodInsert() {
        foodArray.getChildren().clear();
        try {
            int count = Integer.parseInt(foodAmount.getText());
            for (int i = 0; i < count; i++) {
                TextField data = new TextField();
                data.setPromptText("Wprowadź koszt posiłku " + (i + 1) + " w PLN");
                foodArray.getChildren().add(data);
            }
        } catch (NumberFormatException e) {
            showAlert("Błąd podczas wprowadzania danych", "Podaj poprawną liczbę posiłków");
        }
    }

    public void guideInsert() {
        guideArray.getChildren().clear();
        try {
            int count = Integer.parseInt(guideAmount.getText());
            for (int i = 0; i < count; i++) {
                TextField data = new TextField();
                data.setPromptText("Wprowadź koszt przewodnika " + (i + 1) + " w PLN");
                guideArray.getChildren().add(data);
            }
        } catch (NumberFormatException e) {
            showAlert("Błąd podczas wprowadzania danych", "Podaj poprawną liczbę przewodników");
        }
    }

    public void entranceInsert() {
        entranceArray.getChildren().clear();
        try {
            int count = Integer.parseInt(entranceAmount.getText());
            for (int i = 0; i < count; i++) {
                TextField data = new TextField();
                data.setPromptText("Wprowadź koszt biletu wstępu za osobę " + (i + 1) + " w PLN");
                entranceArray.getChildren().add(data);
            }
        } catch (NumberFormatException e) {
            showAlert("Błąd podczas wprowadzania danych", "Podaj poprawną liczbę wstępów");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private ArrayList<Double> costsFromArray(String data) {
        ArrayList<Double> costs = new ArrayList<>();
        if (data == null || data.trim().isEmpty()) {
            return costs;
        }

        String[] amount = data.split(",");
        for (String a : amount) {
            try {
                costs.add(Double.parseDouble(a.trim()));
            } catch (NumberFormatException e) {
                showAlert("Błąd podczas odczytu danych z listy", "Nie udało wczytać się wszystkich danych.");
            }
        }
        return costs;
    }

    private String getTextFromVBox(VBox vbox) {
        StringBuilder data = new StringBuilder();

        for (Node node : vbox.getChildren()) {
            if (node instanceof TextField) {
                TextField textField = (TextField) node;
                String text = textField.getText();

                if (!data.isEmpty()) {
                    data.append(",");
                }
                data.append(text);
            }
        }

        return data.toString();
    }


    private void loadDataFromFile(VBox vbox, ArrayList<Double> costs) {
        vbox.getChildren().clear();
        for (Double cost : costs) {
            TextField costField = new TextField();
            costField.setText(String.valueOf(cost));
            vbox.getChildren().add(costField);
        }
    }

    /// Program had a problem when the input was declared as a double e.g. margin and it was a same number as integer.
    /// This function is returning number without ".0"
    private String bugFixer(double value) {
        if (value == (int) value) {
            return String.valueOf((int) value);
        }
        return String.valueOf(value);
    }

}
