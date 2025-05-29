package com.example.API_TODOList.Itens;

import org.springframework.stereotype.Component;

@Component
public class ItensMapper {
    
    public ItensDTO toDTO(ItensModel itensModel){
        return new ItensDTO(
        itensModel.getId(), 
        itensModel.getDescricao(), 
        itensModel.isStatus());
        
        
    }

    public ItensModel toModel(ItensDTO itensDTO){
        return new ItensModel(
        itensDTO.getId(), 
        itensDTO.getDescricao(), 
        itensDTO.isStatus());
    }
}
