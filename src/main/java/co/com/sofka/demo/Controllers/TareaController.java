package co.com.sofka.demo.Controllers;

import co.com.sofka.demo.Services.TareaServices;
import co.com.sofka.demo.Models.TareaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class TareaController {

    @Autowired
    private TareaServices tareaServices;

    @GetMapping("/")
    public ResponseEntity<?> Lista(){

        return new ResponseEntity(tareaServices.lista(), HttpStatus.OK);

    }
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody TareaModel tareaModel){

        return new ResponseEntity(tareaServices.save(tareaModel), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id){
        return new ResponseEntity(tareaServices.delete(id),HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?>updateState(@PathVariable("id") Long id){
        return new ResponseEntity(tareaServices.updateState(id),HttpStatus.OK);
    }

    @PatchMapping("/")
    public ResponseEntity<?>updateName(@RequestBody TareaModel tareaModel){
        return new ResponseEntity(tareaServices.updateName(tareaModel),HttpStatus.OK);
    }



}
