package br.com.brothers.erp.controller;

import br.com.brothers.erp.model.Venda;
import br.com.brothers.erp.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<Venda>> findAll(){
        try{
            return ResponseEntity.ok().body(vendaService.getAll());
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Venda> getById(@PathVariable Long id){
        try{
            Venda venda = vendaService.findById(id);
            if(venda != null){
                return ResponseEntity.ok().body(venda);
            }
            return ResponseEntity.noContent().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity save(@RequestBody Venda venda){
        try{
            vendaService.save(venda);
            return ResponseEntity.ok().body("Inserido com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody Venda venda){
        try{
            vendaService.update(id, venda);
            return ResponseEntity.ok().body("Atualizado com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            vendaService.delete(id);
            return ResponseEntity.ok().body("deletado com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}