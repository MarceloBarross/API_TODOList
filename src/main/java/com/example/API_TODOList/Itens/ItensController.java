package com.example.API_TODOList.Itens;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("itens")
public class ItensController {

    private ItensService itensService;

    public ItensController(ItensService itensService){
        this.itensService = itensService;
    }


    @GetMapping("/read")
    public ResponseEntity<List<ItensDTO>> readAll(){
        List<ItensDTO> itensDTOs = itensService.readAll();
        return ResponseEntity.ok(itensDTOs);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> readOne(@PathVariable Long id){
        ItensDTO itensDTO = itensService.readOne(id);
        if (itensDTO != null) {
            return ResponseEntity.ok(itensDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item com id: " + id + " nao encontrado");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ItensDTO itensDTO){
        ItensDTO itenCriado = itensService.create(itensDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body("Item '" + itenCriado.getDescricao() + "' criado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (itensService.readOne(id) != null) {
            itensService.delete(id);
            return ResponseEntity.ok("Item deletado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item com id: " + id + " nao encontrado");
    }

    @PutMapping("/updateDescricao/{id}")
    public ResponseEntity<?> updateDescricao(@PathVariable Long id, @RequestBody ItensDTO data){
        if (itensService.readOne(id) != null) {
            ItensDTO itensDTO = itensService.updateDescricao(id, data);
            return ResponseEntity.ok(itensDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item com id: " + id + " nao encontrado");
    }
    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody ItensModel data){
        if (itensService.readOne(id) != null) {
            ItensDTO itensDTO = itensService.updateStatus(id, data);
            return ResponseEntity.ok(itensDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item com id: " + id + " nao encontrado");
    }
    
}
