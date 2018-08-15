package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import ru.method.figurese.models.TaskList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestQuestionController {

    private int index=0;
    @FXML
    ImageView taskImage;

    @FXML
    public void initialize(){
        try {
            Image image = new Image(new FileInputStream("C:\\Users\\korshun\\Desktop\\JavaFX\\testApplication\\src\\sample\\pictures\\1.png"));
            taskImage.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void chooseAnswer(ActionEvent actionEvent) {
        try {
            TaskList taskList = FirstFormController.taskList;
            if (FirstFormController.index<taskList.size()-1) {
                index = ++FirstFormController.index;
                Image image = new Image(new FileInputStream(taskList.getElement(index).getPictureAddress()));
                taskImage.setImage(image);//taskList.getTask(index).getPictureAddress()));
                taskList.getElement(--index).setRealAnswer(((Button)actionEvent.getSource()).getText());
            }
            else {
                //fxml-файл новой формы
                Parent panel = FXMLLoader.load(getClass().getResource("../ru/method/figurese/fxml/endform.fxml"));
                AnchorPane tilePane = (AnchorPane) ((Button)actionEvent.getSource()).getParent().getParent().getParent().getParent();
                AnchorPane.setBottomAnchor(panel,0.0);
                AnchorPane.setLeftAnchor(panel,0.0);
                AnchorPane.setRightAnchor(panel,0.0);
                AnchorPane.setTopAnchor(panel,0.0);
                tilePane.getChildren().clear();
                tilePane.getChildren().add(panel);
                //Main.primaryStage.setTitle("Результат теста «Включенные фигуры»");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
