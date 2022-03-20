package br.com.brothers.erp.controller;

import br.com.brothers.erp.model.Pedido;
import br.com.brothers.erp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        try{
            return ResponseEntity.ok().body(pedidoService.getAll());
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable Long id){
        try{
            Pedido pedido = pedidoService.findById(id);
            if(pedido != null){
                return ResponseEntity.ok().body(pedido);
            }
            return ResponseEntity.noContent().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity save(@RequestBody Pedido pedido){
        try{
            pedidoService.save(pedido);
            return ResponseEntity.ok().body("Inserido com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody Pedido pedido){
        try{
            pedidoService.update(id, pedido);
            return ResponseEntity.ok().body("Atualizado com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            pedidoService.delete(id);
            return ResponseEntity.ok().body("deletado com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

}