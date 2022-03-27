package br.com.brothers.erp.service;

import br.com.brothers.erp.model.UserErp;
import br.com.brothers.erp.repository.UserErpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserErpService implements UserDetailsService {

    @Autowired
    private UserErpRepository userErpRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userErpRepository
                .findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
    }

    @Transactional(readOnly = true)
    public UserErp findById(Long id){
        try{
            Optional<UserErp> user = userErpRepository.findById(id);
            if(user.isPresent()){
                return user.get();
            }else{
                return null;
            }
        }catch (Exception ex){
            throw new RuntimeException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(UserErp user){
        try{
            userErpRepository.save(user);
        }catch (Exception ex){
            throw new RuntimeException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Long id, UserErp user){
        try{
            Optional<UserErp> userOp = userErpRepository.findById(id);
            if(userOp.isPresent()){
                user.setId(id);
                userErpRepository.save(user);
            }
        }catch (Exception ex){
            throw new RuntimeException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long id){
        try{
            Optional<UserErp> userOp = userErpRepository.findById(id);
            if(userOp.isPresent()){
                userErpRepository.delete(userOp.get());
            }
        }catch (Exception ex){
            throw new RuntimeException();
        }
    }}
