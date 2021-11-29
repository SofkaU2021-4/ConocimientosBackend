package co.com.sofka.demo.Services;
import co.com.sofka.demo.Models.ToDoModel;
import co.com.sofka.demo.Repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ToDoServices {
    @Autowired
    ToDoRepository toDoRepository;

    public Iterable<ToDoModel> lista(){
        return  toDoRepository.findAll();
    }

    public ToDoModel get(Long id){
        return toDoRepository.findById(id).orElseThrow();
    }


    public ToDoModel save(ToDoModel toDoModel){

        return toDoRepository.save(toDoModel);

    }

    public String delete(Long id){
        toDoRepository.delete(get(id));
        return "Eliminado";

    }

    public ToDoModel updateState(ToDoModel toDoModel){

        return toDoRepository.save(toDoModel);

    }
    public ToDoModel updateName(ToDoModel toDoModel){
        ToDoModel update = get(toDoModel.getId());
        update.setName(toDoModel.getName());
        return toDoRepository.save(toDoModel);

    }
}

