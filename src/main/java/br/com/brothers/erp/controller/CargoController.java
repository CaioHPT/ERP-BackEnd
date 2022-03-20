package br.com.brothers.erp.controller;

import br.com.brothers.erp.model.Cargo;
import br.com.brothers.erp.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<Cargo>> findAll(){
        try{
            return ResponseEntity.ok().body(cargoService.getAll());
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cargo> getById(@PathVariable Long id){
        try{
            Cargo cargo = cargoService.findById(id);
            if(cargo != null){
                return ResponseEntity.ok().body(cargo);
            }
            return ResponseEntity.noContent().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity save(@RequestBody Cargo cargo){
        try{
           cargoService.save(cargo);
           return ResponseEntity.ok().body("Inserido com sucesso");
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody Cargo cargo){
        try{
            Cargo cargoGet = cargoService.findById(id);
            if(cargoGet != null){
                cargoService.update(id, cargo);
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
            Cargo cargo = cargoService.findById(id);
            if(cargo != null){
                cargoService.delete(id);
                return ResponseEntity.ok().body("deletado com sucesso");
            }else{
                return ResponseEntity.noContent().build();
            }
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
