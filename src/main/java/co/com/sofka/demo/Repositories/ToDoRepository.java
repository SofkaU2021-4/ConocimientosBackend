package co.com.sofka.demo.Repositories;

import co.com.sofka.demo.Models.ToDoModel;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoModel, Long> {
}
