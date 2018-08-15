package ru.method.figurese.styles;

import java.util.*;

public class FieldDependenceStyle implements CognitiveStyle {

    public static  final String FIELD_DEPENDENCE_STRING = "Полезависимость";
    public static  final String FIELD_INDEPENDENCE_STRING = "Поленезависимость";

    public static Map<String, String> createDependenceMap(){
        return new HashMap<String, String>(){{
            put("Методика «Включенные фигуры»","../ru/method/figurese/fxml/firstform.fxml");//"../ru/method/figurese/fxml/testquestionform.fxml");
            put("Методика «Стержень — рамка»","../ru/method/figurese/fxml/defaultform.fxml");
        }};
    }

    private String fieldDependenceString =
            "Полезависимые люди при восприятии информации больше внимания уделяют фону (полю) и меньше – деталям. " +
            "В данном случае человек ориентируется на внешние факторы при обработке новых данных. " +
            "Таким ученикам при обучении нужно больше наглядного материала, большие куски текста следует показывать " +
            "в структурированном виде с большим количеством схем, таблиц, списков и пр.";

    private String fieldIndependenceString =
            "Люди с поленезависимостью напротив обращают пристальное внимание на детали и ориентируются на какие-то внутренние (личностные) " +
                    "факторы при восприятии информации. Ученики с данным когнитивным стилем легко работают с текстами, делают меньшее количество ошибок " +
                    "при написании и/или редактировании, склонны к детальному разбору материала. При обучении наглядность им не важна.";

    private String fieldDependenceProfessions =
            "Расположены к социальным контактам";

    private String fieldIndependenceProfessions =
            "Интеллектуальная деятельность";

    @Override
    public String getDescription(double koefficient) {
        if (Math.abs(koefficient-2.5)<0.0001){
            return fieldDependenceString+"\n"+fieldIndependenceString;
        }
        else if (koefficient<2.5) {
            return fieldDependenceString;
        }
        else {
            return fieldIndependenceString;
        }
    }

    @Override
    public String getProfession(double koefficient) {
        if (Math.abs(koefficient-2.5)<0.0001){
            return fieldDependenceProfessions+"\n"+fieldIndependenceProfessions;
        }
        else if (koefficient<2.5) {
            return fieldDependenceProfessions;
        }
        else {
            return fieldIndependenceProfessions;
        }
    }
}
