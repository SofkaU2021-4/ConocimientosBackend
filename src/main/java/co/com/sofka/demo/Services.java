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

    public Todo updateState(Long id){
        Todo todo = get(id);
        todo.setCompleted(true);
        return repository.save(todo);

    }
    public Todo updateName(Todo todo){
        Todo update = get(todo.getId());
        update.setName(todo.getName());
        return repository.save(todo);

    }
}
