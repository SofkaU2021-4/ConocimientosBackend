package co.com.sofka.demo.Models;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class TareaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Nombre")
    private String name;
    private boolean isCompleted;
    @OneToMany()
    private List<ToDoModel> toDo;


    public List<ToDoModel> getToDo() {
        return toDo;
    }

    public void setToDo(List<ToDoModel> toDo) {
        this.toDo = toDo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}


