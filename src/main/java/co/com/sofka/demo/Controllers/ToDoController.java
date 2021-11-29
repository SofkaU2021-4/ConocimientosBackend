package co.com.sofka.demo.Controllers;



import co.com.sofka.demo.Models.ToDoModel;
import co.com.sofka.demo.Services.ToDoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ToDo" )
public class ToDoController {

    @Autowired
    private ToDoServices toDoServices;

    @GetMapping("/")
    public ResponseEntity<?> Lista(){

        return new ResponseEntity(toDoServices.lista(), HttpStatus.OK);

    }
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody ToDoModel toDoModel){

        return new ResponseEntity(toDoServices.save(toDoModel), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id){
        return new ResponseEntity(toDoServices.delete(id),HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?>updateState(@RequestBody ToDoModel toDoModel){
        return new ResponseEntity(toDoServices.updateState(toDoModel),HttpStatus.OK);
    }

    @PatchMapping("/")
    public ResponseEntity<?>updateName(@RequestBody ToDoModel tareaModel){
        return new ResponseEntity(toDoServices.updateName(tareaModel),HttpStatus.OK);
    }
}
