package com.example.API_TODOList.Itens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensDTO {
    private long id;
    private String descricao;
    private boolean status;
}
