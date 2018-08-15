package ru.method.figurese.styles;

import java.util.HashMap;
import java.util.Map;

public class RangeOfEquivalenceStyle implements CognitiveStyle {

    public static  final String NARROW_RANGE_OF_EQUIVALENCE = "Узкий диапазон эквивалентности";
    public static  final String WIDE_RANGE_OF_EQUIVALENCE = "Широкий диапазон эквивалентности";

    public static Map<String, String> createDependenceMap(){
        return new HashMap<String, String>(){{
            put("Тест Т. Петтигрю","../ru/method/figurese/fxml/rangeofequivalence.fxml");
            put("Тест С. Филленбаума","../ru/method/figurese/fxml/firstform.fxml");
            put("Тест синонимов","../ru/method/figurese/fxml/firstform.fxml");
            put("Методика «Свободная сортировка объектов»","../ru/method/figurese/fxml/firstform.fxml");
            put("Методика «Константность размера»","../ru/method/figurese/fxml/firstform.fxml");
        }};
    }

    private String narrowRangeString =
            "Преобладание узкого диапазона (аналитичность) говорит о том, что человек склонен искать различия в воспринимаемых объектах. " +
                    "Такие ученики легко справляются с заданиями, требующими обращать внимание на много различных аспектов. " +
                    "При этом лучше не давать им для запоминания большое количество информации сразу – нужно разбивать ее на части.";

    private String wideRangeString  =
            "Широкий диапазон (синтетичность) ориентирует человека на поиск общего между объектами. " +
                    "Дети с преобладанием данного типа когнитивного стиля могут воспринимать и запоминать большой объем информации сразу. " +
                    "Но лучше не давать им для решения несколько разноплановых задач одновременно.";

    private String narrowRangeProfessions =
            "Расположены к социальным контактам";

    private String wideRangeProfessions =
            "Интеллектуальная деятельность";

    @Override
    public String getDescription(double koefficient) {
        if (Math.abs(koefficient-0.5)<0.0001){
            return narrowRangeString+"\n"+wideRangeString;
        }
        else if (koefficient<0.5) {
            return narrowRangeString;
        }
        else {
            return wideRangeString;
        }
    }

    @Override
    public String getProfession(double koefficient) {
        if (Math.abs(koefficient-0.5)<0.0001){
            return narrowRangeProfessions+"\n"+wideRangeProfessions;
        }
        else if (koefficient<0.5) {
            return narrowRangeProfessions;
        }
        else {
            return wideRangeProfessions
                    ;
        }
    }
}
