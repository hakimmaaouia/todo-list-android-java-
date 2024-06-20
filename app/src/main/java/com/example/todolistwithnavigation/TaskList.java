package com.example.todolistwithnavigation;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<Task> list;

    public TaskList() {
        list = new ArrayList<>();
    }

    // Create a new task
    public void addTask(Task task) {
        list.add(task);
    }

    // Read all tasks
    public List<Task> getList() {
        return new ArrayList<>(list);
    }
    public List<String> getListToString() {
        List<String> stringList = new ArrayList<>();
        for (Task task : list) {
            stringList.add(task.toString());
        }
        return stringList;
    }

    // Read a task by ID
    public Task getTask(int id) {
        for (Task task : list) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null; // or throw an exception
    }

    // Update a task by ID
    public boolean updateTask(int id, Task updatedTask) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.set(i, updatedTask);
                return true;
            }
        }
        return false;
    }

    // Delete a task by ID
    public boolean deleteTask(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }




}
