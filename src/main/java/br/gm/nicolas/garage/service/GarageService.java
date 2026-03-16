/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.nicolas.garage.service;

import br.gm.nicolas.garage.DTO.VeiculosMinDTO;
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
    
    public List<VeiculosMinDTO> findAll() {
        
        List<Veiculos> result = garageRepository.findAll();
        
        List<VeiculosMinDTO> resultDTO = result.stream()
                .map(x -> new VeiculosMinDTO(x)).toList();
        
        return resultDTO;
        
    }
    
    public Veiculos findById(long id) {
        
        Veiculos result = garageRepository.findById(id);
        return result;
        
    }
    
    public List<Veiculos> findByCor(String cor) {
        
        List<Veiculos> result = garageRepository.findByCorIgnoreCase(cor);
        return result;
        
    }
    
    public List<VeiculosMinDTO> findByAno(int ano) {
        
        List<Veiculos> resultVeiculos = garageRepository.findByAno(ano);
        
        List<VeiculosMinDTO> resultDTO = resultVeiculos.stream()
                .map(x -> new VeiculosMinDTO(x)).toList();
        
        return resultDTO;
        
    }
    
    public List<Veiculos> findByMarca(String marca) {
        
        List<Veiculos> result = garageRepository.findByMarcaIgnoreCase(marca);
        return result;
        
    }
    
    public List<Veiculos> findByModelo(String modelo) {
        
        List<Veiculos> result = garageRepository.findByModeloIgnoreCase(modelo);
        return result;
        
    }
    
    public Veiculos saveVeiculo(Veiculos novoVeiculo) {
        
        Veiculos veiculo = garageRepository.save(novoVeiculo);
        return veiculo;
        
    }
}
