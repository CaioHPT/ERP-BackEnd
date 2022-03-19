package br.com.brothers.erp.service;

import br.com.brothers.erp.model.Endereco;
import br.com.brothers.erp.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public List<Endereco> getAll(){
        try{
            return enderecoRepository.findAll();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(readOnly = true)
    public Endereco findById(Long id){
        try{
            Optional<Endereco> endereco = enderecoRepository.findById(id);
            if(endereco.isPresent()){
                return endereco.get();
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
            Optional<Endereco> endereco = enderecoRepository.findById(id);
            if (endereco.isPresent()){
                enderecoRepository.delete(endereco.get());
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Endereco endereco){
        try{
            enderecoRepository.save(endereco);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(Long id, Endereco endereco){
        try{
            Optional<Endereco> enderecoOp = enderecoRepository.findById(id);
            if (enderecoOp.isPresent()){
                endereco.setId(id);
                enderecoRepository.save(endereco);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}