package br.com.brothers.erp.service;

import br.com.brothers.erp.model.Endereco;
import br.com.brothers.erp.model.Fornecedor;
import br.com.brothers.erp.repository.EnderecoRepository;
import br.com.brothers.erp.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Transactional(readOnly = true)
    public List<Fornecedor> getAll(){
        try{
            return fornecedorRepository.findAll();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(readOnly = true)
    public Fornecedor findById(Long id){
        try{
            Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
            if(fornecedor.isPresent()){
                return fornecedor.get();
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
            Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
            if (fornecedor.isPresent()){
                fornecedorRepository.delete(fornecedor.get());
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Fornecedor fornecedor){
        try{
            fornecedorRepository.save(fornecedor);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(Long id, Fornecedor fornecedor){
        try{
            Optional<Fornecedor> fornecedorOp = fornecedorRepository.findById(id);
            if (fornecedorOp.isPresent()){
                fornecedor.setId(id);
                fornecedorRepository.save(fornecedor);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}