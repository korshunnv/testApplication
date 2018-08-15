package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import ru.method.figurese.models.MiniMax;
import ru.method.figurese.models.Question;
import ru.method.figurese.models.QuestionList;

import java.io.IOException;

public class RangeOfEquivalenceController {

    int index=0;

    QuestionList questionList;

    private double [] answers;

    public static double countLarge;

    @FXML
    Button nextQuestionButton;

    @FXML
    TextArea textQuestionTextArea;

    @FXML
    TextArea questionMinTextArea;

    @FXML
    TextArea questionMaxTextArea;

    @FXML
    Slider questionMinSlider;

    @FXML
    Slider questionMaxSlider;

    @FXML
    public void initialize(){
        index=0;
        questionList=QuestionList.createQuestionList();
        answers = new double[questionList.size()];
        Question question=questionList.getElement(index);
        printQuestion(question);
    }

    private void printQuestion(Question question){
        textQuestionTextArea.setText(question.getText());
        questionMinTextArea.setText(question.getQuestionMin());
        questionMaxTextArea.setText(question.getQuestionMax());
        questionMinSlider.setMin(question.getMin());
        questionMinSlider.setMax(question.getMax());
        questionMinSlider.setValue(question.getMin());
        questionMaxSlider.setMin(question.getMin());
        questionMaxSlider.setMax(question.getMax());
        questionMaxSlider.setValue(question.getMin());
    }

    public void nextQuestion(ActionEvent actionEvent) {
        takeAnswer();
        if (index<questionList.size()-1) {
            index++;
            Question question = questionList.getElement(index);
            printQuestion(question);
        }
        else {
            int k=0;
            for (double elem:answers) {
                if (elem>0.5){
                    k++;
                }
            }
            countLarge=k/questionList.size();
            //fxml-файл новой формы
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../ru/method/figurese/fxml/endquestionform.fxml"));
                Main.primaryStage.setTitle("результат методики «Средние суждения»");
                Main.primaryStage.setMinHeight(550);
                Main.primaryStage.setMinWidth(458);
                Main.primaryStage.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void takeAnswer(){
        double max=questionMaxSlider.getValue();
        double min=questionMinSlider.getValue();
        answers[index]=new MiniMax(min,max).absMaxMin()/questionList.getElement(index).getMiniMax().absMaxMin();
    }
}
