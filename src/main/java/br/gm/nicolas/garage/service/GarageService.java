/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.nicolas.garage.service;

import br.gm.nicolas.garage.entities.Veiculos;
import br.gm.nicolas.garage.repositories.GaragemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nckz06_
 */
@Service
public class GarageService {
    
    @Autowired
    private GaragemRepository garageRepository;
    
    public List<Veiculos> findAll() {
        
        List<Veiculos> result = garageRepository.findAll();
        return result;
        
    }
    
    public List<Veiculos> findById(long id) {
        
        List<Veiculos> result = garageRepository.findById(id);
        return result;
        
    }
}
