package ru.method.figurese.models;

import java.util.*;

public class TaskList {

    public Task getElement(int index) {
        return taskList.get(index);
    }

    public static TaskList createTaskList(){
        if (instance==null) {
            return new TaskList();
        };
        return instance;
    }
    public int size(){
        return  taskList.size();
    }

    private static TaskList instance = null;
    private List<Task> taskList;
    private final String address="/sample/pictures/";
    //private final String address="C:\\Users\\korshun\\Desktop\\JavaFX\\testApplication\\src\\sample\\pictures\\";
    private final String fileExtension=".png";

    private TaskList(){
        taskList=new ArrayList<Task>();
        taskList.add(new Task("А"));
        taskList.add(new Task("Б"));
        taskList.add(new Task("В"));
        taskList.add(new Task("Г"));
        taskList.add(new Task("В"));
        taskList.add(new Task("В"));
        taskList.add(new Task("А"));
        taskList.add(new Task("В"));
        taskList.add(new Task("Д"));
        taskList.add(new Task("Д"));
        taskList.add(new Task("Б"));
        taskList.add(new Task("А"));
        taskList.add(new Task("А"));
        taskList.add(new Task("В"));
        taskList.add(new Task("Б"));
        taskList.add(new Task("Д"));
        taskList.add(new Task("А"));
        taskList.add(new Task("Д"));
        taskList.add(new Task("Б"));
        taskList.add(new Task("В"));
        taskList.add(new Task("Г"));
        taskList.add(new Task("Б"));
        taskList.add(new Task("Г"));
        taskList.add(new Task("А"));
        taskList.add(new Task("Д"));
        taskList.add(new Task("Б"));
        taskList.add(new Task("А"));
        taskList.add(new Task("Д"));
        taskList.add(new Task("В"));
        taskList.add(new Task("Б"));

        for (int i=0; i<taskList.size(); i++){
            String fileAddress=address+(i+1)+fileExtension;
            taskList.get(i).setPictureAddress(fileAddress);
        }
    }
}
