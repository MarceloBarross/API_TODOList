package com.example.API_TODOList.Itens;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ItensService {

    private ItensRepository itensRepository;

    public ItensService(ItensRepository itensRepository){
        this.itensRepository = itensRepository;
    }

    public List<ItensModel> readAll(){
        return itensRepository.findAll();
    }

    public ItensModel readOne(Long id){
        Optional<ItensModel> itensModel = itensRepository.findById(id);
        ItensModel item = itensModel.get();
        return item;
    }
    
    public ItensModel create(ItensModel itensModel){
        return itensRepository.save(itensModel);
    }
    
    public void delete(Long id){
        itensRepository.deleteById(id);
    }
    
    public ItensModel update(Long id, ItensModel itensModel){
        if(itensRepository.existsById(id)){
            itensModel.setId(id);
            return itensRepository.save(itensModel);
        }
        return null;
    }
    
}
