package br.com.brothers.erp.controller;

import br.com.brothers.erp.model.Produto;
import br.com.brothers.erp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        try{
            return ResponseEntity.ok().body(produtoService.getAll());
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id){
        try{
            Produto produto = produtoService.findById(id);
            if(produto != null){
                return ResponseEntity.ok().body(produto);
            }
            return ResponseEntity.noContent().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity save(@RequestBody Produto produto){
        try{
            produtoService.save(produto);
            return ResponseEntity.ok().body("Inserido com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody Produto produto){
        try{
            Produto produtoGet = produtoService.findById(id);
            if(produtoGet != null){
                produtoService.update(id, produto);
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
            Produto produto = produtoService.findById(id);
            if(produto != null){
                produtoService.delete(id);
                return ResponseEntity.ok().body("deletado com sucesso");
            }else{
                return ResponseEntity.noContent().build();
            }
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}