package br.com.brothers.erp.controller;

import br.com.brothers.erp.model.Endereco;
import br.com.brothers.erp.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        try{
            return ResponseEntity.ok().body(enderecoService.getAll());
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> getById(@PathVariable Long id){
        try{
            Endereco endereco = enderecoService.findById(id);
            if(endereco != null){
                return ResponseEntity.ok().body(endereco);
            }
            return ResponseEntity.noContent().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity save(@RequestBody Endereco endereco){
        try{
            enderecoService.save(endereco);
            return ResponseEntity.ok().body("Inserido com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody Endereco endereco){
        try{
            Endereco enderecoGet = enderecoService.findById(id);
            if(enderecoGet != null){
                enderecoService.update(id, endereco);
                return ResponseEntity.ok().body("Atualizado com sucesso");
            }else{
                return ResponseEntity.noContent().build();
            }

        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            Endereco endereco = enderecoService.findById(id);
            if(endereco != null){
                enderecoService.delete(id);
                return ResponseEntity.ok().body("deletado com sucesso");
            }else{
                return ResponseEntity.noContent().build();
            }
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

}
