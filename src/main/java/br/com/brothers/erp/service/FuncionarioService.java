package br.com.brothers.erp.service;

import br.com.brothers.erp.model.Funcionario;
import br.com.brothers.erp.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional(readOnly = true)
    public List<Funcionario> getAll(){
        try{
            return funcionarioRepository.findAll();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(readOnly = true)
    public Funcionario findById(Long id){
        try{
            Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
            if(funcionario.isPresent()){
                return funcionario.get();
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
            Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
            if (funcionario.isPresent()){
                funcionarioRepository.delete(funcionario.get());
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Funcionario funcionario){
        try{
            funcionarioRepository.save(funcionario);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(Long id, Funcionario funcionario){
        try{
            Optional<Funcionario> funcionarioOp = funcionarioRepository.findById(id);
            if (funcionarioOp.isPresent()){
                funcionario.setId(id);
                funcionarioRepository.save(funcionario);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
