/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.de.fechas;

import java.time.LocalDate;
import java.util.ArrayList;


public class Licencia_temporal extends Licencia{
    private LocalDate fecha_caducidad;
    private boolean caduca = false;

    public Licencia_temporal(LocalDate fecha_caducidad, String email, String servicio) {
        super(email, servicio);
        this.fecha_caducidad = fecha_caducidad;
    }
     public Licencia_temporal( String email, String servicio) {
        super(email, servicio);
        this.fecha_caducidad  = fechaCracion.plusMonths(3);
    }
     protected Licencia_temporal(boolean caduca,LocalDate fecha_caducidad, String email , String servicio, LocalDate fechaCreacion, String codigo,boolean revocada, int transacciones, ArrayList<Transaccion> transaccionesArrayList ) {
        super(email ,servicio,fechaCreacion, codigo,revocada, transacciones,transaccionesArrayList );
        this.fecha_caducidad  = fecha_caducidad;
        this.caduca=caduca;
    }

    @Override
    protected Licencia_temporal clone() {
       Licencia_temporal nueva = new Licencia_temporal(this.caduca, this.fecha_caducidad,this.email , this.servicio, this.fechaCracion, this.codigo,this.revocada, this.transacciones, this.transaccionesArrayList);
       return nueva;
    }
     
     
     public void isCaduca(){
        LocalDate actual= LocalDate.now();
         if(actual.isBefore(fecha_caducidad )){
             caduca=true;
         }
         caduca=false;
     }
    @Override
    public boolean isvalida() {
       LocalDate actual= LocalDate.now();
       if(isRevocada()==false && caduca==false ){  
           return true;
       }
       return false;
    }
    
    public void extender(int extender){
        this.fecha_caducidad  = this.fecha_caducidad.plusMonths(extender);
    }
    
    public String toString(){
        String retorno = super.toString();
        retorno +="la fecha de caducidad es :" +this.fecha_caducidad.toString()+" caduca :"+Boolean.toString(caduca);
        return retorno;
    }
  

    

    
    
}
