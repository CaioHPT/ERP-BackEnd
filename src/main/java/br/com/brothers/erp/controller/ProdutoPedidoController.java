package br.com.brothers.erp.controller;

import br.com.brothers.erp.model.Produto_Pedido;
import br.com.brothers.erp.service.ProdutoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtoPedido")
public class ProdutoPedidoController {

    @Autowired
    private ProdutoPedidoService produtoPedidoService;

    @GetMapping
    public ResponseEntity<List<Produto_Pedido>> findAll(){
        try{
            return ResponseEntity.ok().body(produtoPedidoService.getAll());
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto_Pedido> getById(@PathVariable Long id){
        try{
            Produto_Pedido produtoPedido = produtoPedidoService.findById(id);
            if(produtoPedido != null){
                return ResponseEntity.ok().body(produtoPedido);
            }
            return ResponseEntity.noContent().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity save(@RequestBody Produto_Pedido produtoPedido){
        try{
            produtoPedidoService.save(produtoPedido);
            return ResponseEntity.ok().body("Inserido com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody Produto_Pedido produtoPedido){
        try{
            produtoPedidoService.update(id, produtoPedido);
            return ResponseEntity.ok().body("Atualizado com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            produtoPedidoService.delete(id);
            return ResponseEntity.ok().body("deletado com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}