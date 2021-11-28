package co.com.sofka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private Services services;

    @GetMapping("/")
    public ResponseEntity<?> Lista(){

        return new ResponseEntity(services.lista(), HttpStatus.OK);

    }
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Todo todo){

        return new ResponseEntity(services.save(todo), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id){
        return new ResponseEntity(services.delete(id),HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable("id") Long id){
        return new ResponseEntity(services.updateComplete(id),HttpStatus.OK);
    }



}
