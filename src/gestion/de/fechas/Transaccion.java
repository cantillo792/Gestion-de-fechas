/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.de.fechas;

import java.time.LocalDate;

public class Transaccion {
    private final String Codigolicencia;
    private final LocalDate fechaCracion;

    public Transaccion(String Codigolicencia ) {
        this.Codigolicencia = Codigolicencia;
        this.fechaCracion = LocalDate.now();
    }
    public Transaccion(String Codigolicencia,LocalDate fechaCreacion ) {
        this.Codigolicencia = Codigolicencia;
        this.fechaCracion = fechaCreacion;
    }

    public String getLicencia() {
        return this.Codigolicencia;
    }

    public LocalDate getFechaCracion() {
        return this.fechaCracion;
    }
            
    @Override
    public String toString(){
        return " licencia: "+this.Codigolicencia+" creado :"+this.fechaCracion;
    }
    
    
    
}
