package br.com.brothers.erp.controller;

import br.com.brothers.erp.model.Fornecedor;
import br.com.brothers.erp.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll(){
        try{
            return ResponseEntity.ok().body(fornecedorService.getAll());
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Fornecedor> getById(@PathVariable Long id){
        try{
            Fornecedor fornecedor = fornecedorService.findById(id);
            if(fornecedor != null){
                return ResponseEntity.ok().body(fornecedor);
            }
            return ResponseEntity.noContent().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity save(@RequestBody Fornecedor fornecedor){
        try{
            fornecedorService.save(fornecedor);
            return ResponseEntity.ok().body("Inserido com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody Fornecedor fornecedor){
        try{
            fornecedorService.update(id, fornecedor);
            return ResponseEntity.ok().body("Atualizado com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            fornecedorService.delete(id);
            return ResponseEntity.ok().body("deletado com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

}