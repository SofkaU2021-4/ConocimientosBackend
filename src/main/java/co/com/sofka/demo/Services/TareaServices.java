package co.com.sofka.demo.Services;


import co.com.sofka.demo.Models.TareaModel;
import co.com.sofka.demo.Repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TareaServices {
    @Autowired
    private TareaRepository tareaRepository;

    public Iterable<TareaModel> lista(){
        return  tareaRepository.findAll();
    }

    public TareaModel get(Long id){
        return tareaRepository.findById(id).orElseThrow();
    }


    public TareaModel save(TareaModel tareaModel){

        return tareaRepository.save(tareaModel);

    }

    public String delete(Long id){
        tareaRepository.delete(get(id));
        return "Eliminado";

    }

    public TareaModel updateState(Long id){
        TareaModel tareaModel = get(id);
        tareaModel.setCompleted(true);
        return tareaRepository.save(tareaModel);

    }
    public TareaModel updateName(TareaModel tareaModel){
        TareaModel update = get(tareaModel.getId());
        update.setName(tareaModel.getName());
        return tareaRepository.save(tareaModel);

    }
}
