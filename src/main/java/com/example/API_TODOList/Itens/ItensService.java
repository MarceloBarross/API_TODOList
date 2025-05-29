package com.example.API_TODOList.Itens;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ItensService {

    private ItensRepository itensRepository;
    private ItensMapper itensMapper;

    public ItensService(ItensRepository itensRepository, ItensMapper itensMapper){
        this.itensRepository = itensRepository;
        this.itensMapper = itensMapper;
    }

    public List<ItensDTO> readAll(){
        List<ItensModel> itensModels = itensRepository.findAll();
        List<ItensDTO> itensDTOs = itensModels.stream().map(itensMapper::toDTO).collect(Collectors.toList());
        return itensDTOs;
    }

    public ItensDTO readOne(Long id){
        Optional<ItensModel> itensModel = itensRepository.findById(id);
        return itensModel.map(itensMapper::toDTO).orElse(null);
    }
    
    public ItensDTO create(ItensDTO itensDTO){
        ItensModel itensModel = itensMapper.toModel(itensDTO);
        itensModel = itensRepository.save(itensModel);
        return itensMapper.toDTO(itensModel);
    }
    
    public void delete(Long id){
        itensRepository.deleteById(id);
    }
    
    public ItensDTO updateDescricao(Long id, ItensDTO data){

        return itensRepository.findById(id)
        .map(itensModel -> {
            itensModel.setDescricao(data.getDescricao());
            itensModel = itensRepository.save(itensModel);
            return itensMapper.toDTO(itensModel);
        })
        .orElse(null);
    }
    public ItensDTO updateStatus(Long id, ItensModel data){

        return itensRepository.findById(id)
        .map(itensModel -> {
            itensModel.setStatus(data.isStatus());
            itensModel = itensRepository.save(itensModel);
            return itensMapper.toDTO(itensModel);
        })
        .orElse(null);
    }
    
}
