/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.nicolas.garage.controllers;

import br.gm.nicolas.garage.DTO.VeiculosMinDTO;
import br.gm.nicolas.garage.entities.Veiculos;
import br.gm.nicolas.garage.service.GarageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@CrossOrigin
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
    public ResponseEntity<Veiculos> findById(@PathVariable long idNum) {
            
        Veiculos result = garageService.findById(idNum);
        
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
    
    
    @GetMapping("/marca/{marcaName}")
    public ResponseEntity<List<Veiculos>> findByMarcaIgnoreCase(@PathVariable String marcaName) {
        
        List<Veiculos> result = garageService.findByMarca(marcaName);
        
        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
        
    }
    
    
    @GetMapping("/modelo/{modeloName}")
    public ResponseEntity<List<Veiculos>> findByModeloIgnoreCase(@PathVariable String modeloName) {
        
        List<Veiculos> result = garageService.findByModelo(modeloName);
        
        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
        
    }
    
    
    @PostMapping("/forsale")
    public ResponseEntity<Veiculos> saveVeiculo(@RequestBody Veiculos novoVeiculo) {
        
        Optional<Veiculos> optVeiculo = Optional.of(garageService.saveVeiculo(novoVeiculo));
        
        if(optVeiculo.isPresent()) {
            return ResponseEntity.ok(optVeiculo.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
        
    }
}
