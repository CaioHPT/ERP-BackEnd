package br.com.brothers.erp.controller;

import br.com.brothers.erp.model.Funcionario;
import br.com.brothers.erp.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll(){
        try{
            return ResponseEntity.ok().body(funcionarioService.getAll());
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> getById(@PathVariable Long id){
        try{
            Funcionario funcionario = funcionarioService.findById(id);
            if(funcionario != null){
                return ResponseEntity.ok().body(funcionario);
            }
            return ResponseEntity.noContent().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity save(@RequestBody Funcionario funcionario){
        try{
            funcionarioService.save(funcionario);
            return ResponseEntity.ok().body("Inserido com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody Funcionario funcionario){
        try{
            Funcionario funcionarioGet = funcionarioService.findById(id);
            if(funcionarioGet != null){
                funcionarioService.update(id, funcionario);
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
            Funcionario funcionario = funcionarioService.findById(id);
            if(funcionario != null){
                funcionarioService.delete(id);
                return ResponseEntity.ok().body("deletado com sucesso");
            }else{
                return ResponseEntity.noContent().build();
            }
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}