package br.com.brothers.erp.service;

import br.com.brothers.erp.model.Venda;
import br.com.brothers.erp.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Transactional(readOnly = true)
    public List<Venda> getAll(){
        try{
            return vendaRepository.findAll();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(readOnly = true)
    public Venda findById(Long id){
        try{
            Optional<Venda> venda = vendaRepository.findById(id);
            if(venda.isPresent()){
                return venda.get();
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
            Optional<Venda> venda = vendaRepository.findById(id);
            if (venda.isPresent()){
                vendaRepository.delete(venda.get());
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Venda venda){
        try{
            vendaRepository.save(venda);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(Long id, Venda venda){
        try{
            Optional<Venda> vendaOp = vendaRepository.findById(id);
            if (vendaOp.isPresent()){
                venda.setId(id);
                vendaRepository.save(venda);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}