/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.nicolas.garage.DTO;

import br.gm.nicolas.garage.entities.Veiculos;

/**
 *
 * @author digma
 */
public class VeiculosMinDTO {
    
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private long km;
    private String linkImagem;
    
    public VeiculosMinDTO() {
        
    }
    
    public VeiculosMinDTO(Veiculos veiculos) {
        this.marca = veiculos.getMarca();
        this.modelo = veiculos.getModelo();
        this.cor = veiculos.getCor();
        this.ano = veiculos.getAno();
        this.km = veiculos.getKm();
        this.linkImagem = veiculos.getLinkImagem();
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }

    public long getKm() {
        return km;
    }

    public String getLinkImagem() {
        return linkImagem;
    }
    
    
    
}
