package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import ru.method.figurese.models.Task;
import ru.method.figurese.models.TaskList;
import ru.method.figurese.styles.FieldDependenceStyle;

import java.util.Date;

public class EndFormController {

    @FXML
    Label indexLabel;
    @FXML
    Label timeLabel;
    @FXML
    Label trueAnswersCountLabel;
    @FXML
    TextArea descriptionTextArea;
    @FXML
    TextArea professionTextArea;

    @FXML
    public void initialize(){
        int count=0;
        TaskList taskList = FirstFormController.taskList;
        for (int i=0; i<taskList.size(); i++){
            Task task=FirstFormController.taskList.getElement(i);
            if (task.getTrueAnswer().equals(task.getRealAnswer())){
                count++;
            }
        }
        double sec = (new Date().getTime()-FirstFormController.tick)/1000;
        double koefficient=count/(sec/60);
        trueAnswersCountLabel.setText(trueAnswersCountLabel.getText()+" "+count);
        timeLabel.setText(timeLabel.getText()+" "+sec);
        indexLabel.setText(indexLabel.getText()+" "+koefficient);
        descriptionTextArea.setText(new FieldDependenceStyle().getDescription(koefficient));
        professionTextArea.setText(new FieldDependenceStyle().getProfession(koefficient));
    }
}
