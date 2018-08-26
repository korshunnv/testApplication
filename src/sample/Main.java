package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/ru/method/figurese/fxml/homeform.fxml"));
        primaryStage.setTitle("Когнитивные стили и тесты для их определения");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        //primaryStage.sizeToScene();
        primaryStage.show();
        Main.primaryStage=primaryStage;
        primaryStage.getIcons().add(new Image(getClass().getResource("/sample/pictures/icon.png").toString()));
    }


    public static void main(String[] args) {
        launch(args);
    }
}