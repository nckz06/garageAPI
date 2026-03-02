/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.nicolas.garage.controllers;

import br.gm.nicolas.garage.entities.Veiculos;
import br.gm.nicolas.garage.service.GarageService;
import java.util.List;
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
    public List<Veiculos> findAll() {
        List<Veiculos> result = garageService.findAll();
        return result;
    }
    
    
    @GetMapping("/forsale/{idNum}")
    public ResponseEntity<List<Veiculos>> findById(@PathVariable long idNum) {
            
        List<Veiculos> result = garageService.findById(idNum);
        
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
        
    }
}
