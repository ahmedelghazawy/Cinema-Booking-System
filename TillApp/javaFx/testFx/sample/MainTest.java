package sample;

import com.sun.javafx.robot.FXRobot;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.Assert.*;


public class MainTest extends ApplicationTest {

    @Override
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("mainPage.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }



    @Before
    public void setUp () throws Exception {
    }

//    @After
//    public void tearDown () throws Exception {
//        FxToolkit.hideStage();
//        release(new KeyCode[]{});
//        release(new MouseButton[]{});
//    }


    @Test
    public void choseBlackPanther () {
        clickOn("#blackPanther");
    }

}