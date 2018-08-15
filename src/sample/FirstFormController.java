package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import ru.method.figurese.models.TaskList;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;

public class FirstFormController {

    static int index = 0;
    static TaskList taskList;
    static Timer timer;
    static double tick = 0;

    /**
     * Создание новой scene и открытие ее на старой stage
     *
     * @param actionEvent
     */
    public void testStart(ActionEvent actionEvent) {
        try {
            //fxml-файл новой формы
            Parent panel = FXMLLoader.load(getClass().getResource("../ru/method/figurese/fxml/testquestionform.fxml"));
            AnchorPane tilePane = (AnchorPane) ((Button)actionEvent.getSource()).getParent().getParent().getParent();
            AnchorPane.setBottomAnchor(panel,0.0);
            AnchorPane.setLeftAnchor(panel,0.0);
            AnchorPane.setRightAnchor(panel,0.0);
            AnchorPane.setTopAnchor(panel,0.0);
            tilePane.getChildren().clear();
            tilePane.getChildren().add(panel);
            //Main.primaryStage.setTitle("Тест «Включенные фигуры»");
            //создание листа из задач с ответами
            taskList = TaskList.createTaskList();
            //текущее время (мс)
            tick = new Date().getTime();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



