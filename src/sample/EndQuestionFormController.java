package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import ru.method.figurese.models.MiniMax;
import ru.method.figurese.models.Task;
import ru.method.figurese.models.TaskList;
import ru.method.figurese.styles.FieldDependenceStyle;
import ru.method.figurese.styles.RangeOfEquivalenceStyle;

import java.util.Date;

public class EndQuestionFormController {

    @FXML
    Label countLargeAnswers;
    @FXML
    TextArea descriptionTextArea;
    @FXML
    TextArea professionTextArea;

    @FXML
    public void initialize(){
        double koefficient = RangeOfEquivalenceController.countLarge;
        countLargeAnswers.setText(countLargeAnswers.getText()+" "+koefficient);
        descriptionTextArea.setText(new RangeOfEquivalenceStyle().getDescription(koefficient));
        professionTextArea.setText(new FieldDependenceStyle().getProfession(koefficient));
    }
}
