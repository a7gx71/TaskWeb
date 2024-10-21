package com.example.taskmanager.dao;

import com.example.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private List<Task> lists = new ArrayList<>();
    private int currentId = 1;

    public void addTask (String name) {
        Task task = new Task(currentId++, name);
        lists.add(task);
    }

    public List<Task> getAllTask() {
        return lists;
    }

    public void deleteTask (int id) {
        lists.removeIf(task -> task.getId() == id);
    }
}
