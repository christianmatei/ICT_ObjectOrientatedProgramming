package gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import utility.FileHandler;
import utility.Type;

import java.net.URL;
import java.util.ResourceBundle;

public class previewController
        implements Initializable {

    @FXML //fx:id="txtAreaPreview"
    private TextArea txtAreaPreview;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        String content;
        String previewtype;
        previewtype = "";
        if (mainController.j._type == Type.ONEWAY){
            previewtype = "One-way";
        }
        else if (mainController.j._type == Type.RETURN){
            previewtype = "Return";
        }
        else if (mainController.j._type == Type.JOURNEY){
            previewtype = "Journey";
        }
        content = "Name: " + mainController.j._userName + "\n" + "Booking ID: " + mainController.j._referenceID + "\n" + "Trip Type: " + previewtype + "\n" + "Departure(s)/Destination(s): \n" + mainController.j._trips.toString() + "\n" + "Seat Type: " + mainController.j._seatType + "\n" + "Carry-on: " + mainController.j._carryOn + "\n";
        txtAreaPreview.setText(content);
    }

    @FXML
    private void handleExit(ActionEvent e) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void confirmBooking(ActionEvent e) {
        try {
            FileHandler.saveTrip(mainController.j);
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Main.mainstage.setTitle("Airline Booker 9001®");
            Main.mainstage.setScene(new Scene(root, 840, 680));
            Main.mainstage.show();

        }
        catch (Exception e1) {
            System.out.print(e1.getCause());
            System.out.print(e1.toString());
        }
    }
    @FXML
    private void cancel(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Main.mainstage.setTitle("Airline Booker 9001®");
            Main.mainstage.setScene(new Scene(root, 840, 680));
            Main.mainstage.show();
        }
        catch (Exception e1) {
            System.out.print(e1.getCause());
            System.out.print(e1.toString());
        }
    }
}
