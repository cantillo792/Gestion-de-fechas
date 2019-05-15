/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.de.fechas;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author anderson
 */
 public abstract class Licencia {
    protected final String email;
    protected final LocalDate fechaCracion;
    protected final String codigo;
    protected ArrayList<Transaccion> transaccionesArrayList = new ArrayList<>();
    protected int transacciones;
    protected boolean revocada = false;
    protected final String servicio;

    public Licencia(String email , String servicio) {
        this.email = email;
        this.fechaCracion = LocalDate.now();
        this.servicio = servicio;
        this.codigo =  UUID.randomUUID().toString();
    }
     public Licencia(String email , String servicio, LocalDate fechaCreacion, String codigo,boolean revocada, int transacciones, ArrayList<Transaccion> transaccionesArrayList ) {
        this.email = email;
        this.fechaCracion = fechaCreacion;
        this.servicio = servicio;
        this.codigo = codigo;
        this.revocada=revocada;
        this.transacciones=transacciones;
        
         for (Transaccion transaccion : transaccionesArrayList) {
             Transaccion trans = new Transaccion(transaccion.getLicencia(), transaccion.getFechaCracion());
             this.transaccionesArrayList.add(trans);
         }
 
    }
    
    public void revocar(){
         revocada=true;
    }
   
    public abstract boolean isvalida();
    public Transaccion autorizacion(){
        if(isvalida()){
            Transaccion nueva= new Transaccion(this.codigo);
            this.transaccionesArrayList.add(nueva);
            this.transacciones++;
            return nueva;
        }
        return null;
    }


    public int getTransacciones() {
        return transacciones;
    }


    public boolean isRevocada() {
        return revocada;
    }
    
    @Override
    protected Licencia clone(){
        return null;
    }
    @Override
    public String toString(){
        String retorno = "";
        retorno = "email :"+this.email+" creado: "+this.fechaCracion.toString()+" codigo: "+this.codigo+" transsaciones ";
        for (Transaccion xTransaccion : transaccionesArrayList) {
            retorno+="[ "+xTransaccion.toString()+" ]";
        }
      
        retorno+=" numero de trasaciones :"+this.transacciones+ " revodaca = "+Boolean.toString(revocada)+" servicio :"+this.servicio;
        return retorno;
    }

    int  restantes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
