package br.com.brothers.erp.controller;

import br.com.brothers.erp.model.Cliente;
import br.com.brothers.erp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        try{
            return ResponseEntity.ok().body(clienteService.getAll());
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id){
        try{
            Cliente cliente = clienteService.findById(id);
            if(cliente != null){
                return ResponseEntity.ok().body(cliente);
            }
            return ResponseEntity.noContent().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity save(@RequestBody Cliente cliente){
        try{
            clienteService.save(cliente);
            return ResponseEntity.ok().body("Inserido com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody Cliente cliente){
        try{
            Cliente clienteGet = clienteService.findById(id);
            if(clienteGet != null){
                clienteService.update(id, cliente);
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
            Cliente cliente = clienteService.findById(id);
            if(cliente != null){
                clienteService.delete(id);
                return ResponseEntity.ok().body("deletado com sucesso");
            }else{
                return ResponseEntity.noContent().build();
            }
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
