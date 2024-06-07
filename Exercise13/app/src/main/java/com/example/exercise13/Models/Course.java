package com.example.exercise13.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "courses")
public class Course {
    @PrimaryKey
    @NotNull
    private String id;
    private String name;
    private String description;

    public Course(@NotNull String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @NotNull
    public String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

