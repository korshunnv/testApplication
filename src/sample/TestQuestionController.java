package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ru.method.figurese.models.TaskList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestQuestionController {

    int index=0;
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
                Parent root = FXMLLoader.load(getClass().getResource("../ru/method/figurese/fxml/endform.fxml"));
                Main.primaryStage.setTitle("результат теста «Включенные фигуры»");
                Main.primaryStage.setMinHeight(550);
                Main.primaryStage.setMinWidth(458);
                Main.primaryStage.setScene(new Scene(root));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
