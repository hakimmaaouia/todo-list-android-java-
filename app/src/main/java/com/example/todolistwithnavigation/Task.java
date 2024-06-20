package com.example.todolistwithnavigation;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Task implements Serializable {
    private static int idCounter = 0;

    private int id;
    private String title;
    private String description;
    private boolean complete;
    private String dueDate;

    public Task(String title, String description) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(new Date());
        this.id = ++idCounter;
        this.title = title;
        this.description = description;
        this.complete = false;
        this.dueDate = formattedDate;
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String due_date) {
        this.dueDate = due_date;
    }

    @Override
    public String toString() {
        return title + " - " + description + " (Due: " + dueDate + ")";
    }
}
