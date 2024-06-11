package com.Todolist.Todolist.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name ;
    private String description;
    private String status;
    private String level;
    public Long getId(){
        return id;
    }
    private void setId(long id ){
        this.id = id ;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

}
