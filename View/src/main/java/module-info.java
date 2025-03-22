module prapp.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires prapp;
    requires java.desktop;

    opens prapp.view to javafx.fxml;
    exports prapp.view;
}