package com.demo.cine.service;

import com.demo.cine.Administrador;
import com.demo.cine.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
public class AdministradorService {
	
	@Autowired
    private AdministradorRepository administradorRepository;
    public List<Administrador> listAllUser() {
        return administradorRepository.findAll();
    }

    public void saveAdministrador(Administrador administrador) {
    	administradorRepository.save(administrador);
    }

    public Administrador getAdministrador(Integer id) {
        return administradorRepository.findById(id).get();
    }

    public void deleteAdministrador(Integer id) {
    	administradorRepository.deleteById(id);
    }

}
