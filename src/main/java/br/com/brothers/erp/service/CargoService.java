package br.com.brothers.erp.service;

import br.com.brothers.erp.model.Cargo;
import br.com.brothers.erp.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Transactional(readOnly = true)
    public List<Cargo> getAll(){
        try{
            return cargoRepository.findAll();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(readOnly = true)
    public Cargo findById(Long id){
        try{
            Optional<Cargo> cargo = cargoRepository.findById(id);
            if(cargo.isPresent()){
                return cargo.get();
            }else{
                return null;
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(Long id){
        try{
            Optional<Cargo> cargo = cargoRepository.findById(id);
            if (cargo.isPresent()){
                cargoRepository.delete(cargo.get());
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Cargo cargo){
        try{
            cargoRepository.save(cargo);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(Long id, Cargo cargo){
        try{
            Optional<Cargo> cargoOp = cargoRepository.findById(id);
            if (cargoOp.isPresent()){
                cargo.setId(id);
                cargoRepository.save(cargo);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
