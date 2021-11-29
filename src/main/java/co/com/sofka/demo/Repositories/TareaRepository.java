package co.com.sofka.demo.Repositories;

import co.com.sofka.demo.Models.TareaModel;
import org.springframework.data.repository.CrudRepository;

public interface TareaRepository extends CrudRepository<TareaModel,Long> {
}
