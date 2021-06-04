package com.demo.cine.controller;

import com.demo.cine.Administrador;
import com.demo.cine.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    AdministradorService administradorService;
    Administrador existUser;

    @GetMapping("")
    public List<Administrador> list() {
        return administradorService.listAllUser();
    }

    @GetMapping("/{idAdministrador}")
    public ResponseEntity<Administrador> get(@PathVariable Integer idAdministrador) {
        try {
        	Administrador administrador = administradorService.getAdministrador(idAdministrador);
            return new ResponseEntity<Administrador>(administrador, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Administrador>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Administrador administrador) {
    	administradorService.saveAdministrador(administrador);
    }
    @PutMapping("/{idAdministrador}")
    public ResponseEntity<?> update(@RequestBody Administrador administrador, @PathVariable Integer idAdministrador) {
        try {
        	existUser = administradorService.getAdministrador(idAdministrador);
        	administrador.setIdAdministrador(idAdministrador);           
            administradorService.saveAdministrador(administrador);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{idAdministrador}")
    public void delete(@PathVariable Integer idAdministrador) {

    	administradorService.deleteAdministrador(idAdministrador);
    }
}