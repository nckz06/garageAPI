/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.nicolas.garage.controllers;

import br.gm.nicolas.garage.DTO.VeiculosMinDTO;
import br.gm.nicolas.garage.entities.Veiculos;
import br.gm.nicolas.garage.service.GarageService;
import java.util.List;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
public class GarageController {
    
    @Autowired
    private GarageService garageService;
    
    
    @GetMapping("/forsale")
    public List<VeiculosMinDTO> findAll() {
        List<VeiculosMinDTO> result = garageService.findAll();
        return result;
    }
    
    
    @GetMapping("/forsale/{idNum}")
    public ResponseEntity<VeiculosMinDTO> findById(@PathVariable long idNum) {
            
        VeiculosMinDTO result = garageService.findById(idNum);
        
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
        
    }
    
    
    @GetMapping("/cor/{corName}")
    public ResponseEntity<List<Veiculos>> findByCorIgnoreCase(@PathVariable String corName) {
        
        List<Veiculos> result = garageService.findByCor(corName);
        
        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
        
    }
    
    
    @GetMapping("/ano/{anoNum}")
    public ResponseEntity<List<VeiculosMinDTO>> findByAno(@PathVariable int anoNum) {
        
        List<VeiculosMinDTO> result = garageService.findByAno(anoNum);
        
        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
        
    }
}
