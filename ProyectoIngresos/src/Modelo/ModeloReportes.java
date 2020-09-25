/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author JUAN CAMILO
 */
public class ModeloReportes {
    
    private String tipo, fechad, fechah;
    
    public ModeloReportes(String tipo, String fechad, String fechah) {
        this.tipo = tipo;
        this.fechad = fechad;
        this.fechah = fechah;
    }
    
        public ModeloReportes(){
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechad() {
        return fechad;
    }

    public void setFechad(String fechad) {
        this.fechad = fechad;
    }

    public String getFechah() {
        return fechah;
    }

    public void setFechah(String fechah) {
        this.fechah = fechah;
    }
        
        
}
