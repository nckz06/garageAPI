/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.gm.nicolas.garage.repositories;

import br.gm.nicolas.garage.entities.Veiculos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nckz06_
 */
public interface GaragemRepository extends JpaRepository<Veiculos, Long> {
    
    Veiculos findById(long id);
    List<Veiculos> findByCorIgnoreCase(String cor);
    List<Veiculos> findByAno(int ano);
    
}
