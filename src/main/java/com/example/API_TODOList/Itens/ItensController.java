package com.example.API_TODOList.Itens;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
    public List<ItensModel> readAll(){
        return itensService.readAll();
    }

    @GetMapping("/read/{id}")
    public ItensModel readOne(@PathVariable Long id){
        return itensService.readOne(id);
    }

    @PostMapping("/create")
    public ItensModel create(@RequestBody ItensModel itensModel){
        return itensService.create(itensModel);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        itensService.delete(id);
    }

    @PutMapping("update/{id}")
    public ItensModel update(@PathVariable Long id, @RequestBody ItensModel data){
        return itensService.update(id, data);
    }
    
}
