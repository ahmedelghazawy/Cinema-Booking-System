package src.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene; // what changes within the stage - backed by a scene graph - contains the UI nodes - scenes make it easier to use a container
import javafx.stage.Stage; // top level UI container in JavaFX - the window frame itself


public class Main extends Application {

    private Stage secondStage;

    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("src/sample/mainPage.fxml"));

        Parent ticket = FXMLLoader.load(getClass().getClassLoader().getResource("src/sample/ticketType.fxml"));

        Parent seat = FXMLLoader.load(getClass().getClassLoader().getResource("src/sample/seatSelection.fxml"));

        Parent payment = FXMLLoader.load(getClass().getClassLoader().getResource("src/sample/payment.fxml"));

        window.setTitle("Cine-Toucan");
        window.setScene(new Scene(root, 1165, 700));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


