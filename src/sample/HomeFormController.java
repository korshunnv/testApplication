package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import ru.method.figurese.styles.FieldDependenceStyle;
import ru.method.figurese.styles.RangeOfEquivalenceStyle;

import java.io.IOException;
import java.util.*;

public class HomeFormController {
    /**
     * списки на сцене
     */
    @FXML
    ListView dependenceListView;
    @FXML
    ListView rangeOfEquivalenceListView;
    @FXML
    //TilePane testsPanel;
    AnchorPane testsPanel;
    /**
     * вспомогательная переменная для хранения соответствия списка методик когнитивного стиля и класса данного стиля
     */
    Map<ListView, Map<String, String>> dictionary;
    @FXML
    public void initialize(){
        //создание соответствия списка когнитивного стиля и соответствующего класса с его методиками
        dictionary = new HashMap<ListView, Map<String, String>>(){{
            put(dependenceListView, FieldDependenceStyle.createDependenceMap());
            put(rangeOfEquivalenceListView, RangeOfEquivalenceStyle.createDependenceMap());
        }};
        //инициализация списков на сцене
        setItemsListView(dependenceListView,dictionary.get(dependenceListView));
        setItemsListView(rangeOfEquivalenceListView, dictionary.get(rangeOfEquivalenceListView));

        try {
                Parent panel = FXMLLoader.load(getClass().getResource("../ru/method/figurese/fxml/defaultform.fxml"));
                //panel.setPickOnBounds(true);
                //panel.autosize();
                testsPanel.getChildren().add(panel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * заполнение списков
     * @param listView
     * @param map
     */
    private void setItemsListView(ListView listView, Map<String, String> map){
        List<String> list=new ArrayList<String>();
        String []a = map.keySet().toArray(new String[0]);
        for ( String elem:a) {
            list.add(elem);
        }
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.setAll(list);
        listView.setItems(observableList);
        //listView.getItems().add(dependenceListView.getItems().size(), "Методика «Включенные фигуры»");
    }

    /**
     * обработчик выбора элемента списка
     * @param mouseEvent
     */
    public void chooseItem(MouseEvent mouseEvent) {
        ListView listView = (ListView) mouseEvent.getSource();
        String method = (String) listView.getSelectionModel().getSelectedItem();
        Parent panel = null;
        try {
            String string = dictionary.get(listView).get(method);
            panel = FXMLLoader.load(getClass().getResource(string));
        } catch (IOException e) {
            e.printStackTrace();
        }
        testsPanel.getChildren().clear();
        testsPanel.getChildren().add(panel);
    }
}
