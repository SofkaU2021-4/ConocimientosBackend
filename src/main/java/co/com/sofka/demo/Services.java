package co.com.sofka.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Services {
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

    public String delete(Long id){
        repository.delete(get(id));
        return "Eliminado";

    }

    public Todo updateComplete(Long id){
        Todo todo = get(id);
        todo.setCompleted(true);
        return repository.save(todo);

    }
}
