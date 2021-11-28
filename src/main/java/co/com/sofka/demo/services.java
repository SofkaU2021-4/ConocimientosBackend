package co.com.sofka.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class services {
    @Autowired
    private Repository repository;

    public Iterable<Todo> lista(){
        return  repository.findAll();
    }

    public  Todo get(Long id){
        return repository.findById(id).orElseThrow();
    }


    public Todo save(Todo todo){

        return repository.save(todo);

    }

    public void delete(Long id){
        repository.delete(get(id));

    }
}
