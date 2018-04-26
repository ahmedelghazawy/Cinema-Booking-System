package src.sample; //import package



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene; // what changes within the stage - backed by a scene graph - contains the UI nodes - scenes make it easier to use a container
import javafx.scene.layout.GridPane;
import javafx.stage.Stage; // top level UI container in JavaFX - the window frame itself



public class Main extends Application {

//    private Stage secondStage;

    private Stage window;


    //  Attempt to make the UI dynamic by using Java code to create and manipulate fx elements


    //    @FXML
    //    private GridPane gridPane;

    //    @FXML
    //    private Button blackPanther;
    //
    //    Label label = new Label("Toucan");
    //
    //    @FXML
    //    public void testEvent(ActionEvent event) throws Exception{
    //        if (event.getSource().equals(blackPanther)){
    //            label.setText("Black Panther");
    //
    //            Stage secondStage = new Stage();
    //            secondStage.initModality(Modality.APPLICATION_MODAL);
    //
    //            Group group2 = new Group();
    //            Scene BlackpantherScene = new Scene(group2, 1165,700);
    //
    //            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("src/sample/ticketType.fxml"));
    //
    //            AnchorPane anchorPane2 = new AnchorPane();
    //
    //            label.setUnderline(true);
    //            label.setFont(Font.font("System Bold", 30));
    //            label.setAlignment(Pos.CENTER);
    //
    //            AnchorPane.setLeftAnchor(label, 20.00);
    //            AnchorPane.setTopAnchor(label, 570.00);
    //
    //            secondStage.initOwner(label.getScene().getWindow());
    //            anchorPane2.getChildren().add(label);
    //            group2.getChildren().add(anchorPane2);
    //            group2.getChildren().add(root);
    //
    //
    //        }
    //    }


    @Override
    public void start(Stage primaryStage) throws Exception {


        //  Attempt to make the UI dynamic by using Java code to create and manipulate fx elements


        //
        //        Group myGroup = new Group();
        //        Scene scene = new Scene(myGroup, 1165, 700);
        //
        //        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("src/sample/mainPage.fxml"));
        //
        //
        //        AnchorPane anchorPane = new AnchorPane();
        //
        //
        ////        Label label = new Label("Toucan");
        //        label.setUnderline(true);
        ////        label.setPrefSize(350.00, 40.00);
        //        label.setFont(Font.font("System Bold", 30));
        //        label.setAlignment(Pos.CENTER);
        //
        //        AnchorPane.setLeftAnchor(label, 20.00);
        //        AnchorPane.setTopAnchor(label, 570.00);
        //
        ////        @FXML
        ////        public void testEvent(ActionEvent event) throws Exception{
        ////            if (event.getSource().equals(blackPanther)){
        ////                label.setText("Black Panther");
        ////
        //////                Stage secondStage = new Stage();
        //////                secondStage.initModality(Modality.APPLICATION_MODAL);
        ////
        ////                Group group2 = new Group();
        ////                Scene BlackpantherScene = new Scene(group2, 1165,700);
        ////
        ////                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("src/sample/ticketType.fxml"));
        ////
        ////                AnchorPane anchorPane2 = new AnchorPane();
        ////
        ////                label.setUnderline(true);
        ////                label.setFont(Font.font("System Bold", 30));
        ////                label.setAlignment(Pos.CENTER);
        ////
        ////                AnchorPane.setLeftAnchor(label, 20.00);
        ////                AnchorPane.setTopAnchor(label, 570.00);
        ////
        ////                primaryStage.initOwner(label.getScene().getWindow());
        ////                anchorPane2.getChildren().add(label);
        ////                group2.getChildren().add(anchorPane2);
        ////                group2.getChildren().add(root);
        ////                primaryStage.setScene(BlackpantherScene);
        ////                primaryStage.show();
        ////
        ////            }
        ////        }
        //
        //
        //        anchorPane.getChildren().add(label);
        //        myGroup.getChildren().add(anchorPane);
        ////        myGroup.getChildren().add(root);
        //        primaryStage.setScene(scene);
        //        primaryStage.show();








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