/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.de.fechas;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author anderson
 */
public class Licencia_limitada extends Licencia{
    protected final int  maxTrans;
    protected int transRes;
    public Licencia_limitada(int maxTrans, String email, String servicio) {
        super(email, servicio);
        this.maxTrans = maxTrans;
        this.transRes = maxTrans;
    }
    protected Licencia_limitada(int maxTrans, int transRes,String email , String servicio, LocalDate fechaCreacion, String codigo,boolean revocada, int transacciones, ArrayList<Transaccion> transaccionesArrayList) {
        super(email ,servicio,fechaCreacion, codigo,revocada, transacciones,transaccionesArrayList );
        this.maxTrans = maxTrans;
        this.transRes = transRes;
    }

    public int getMaxTrans() {
        return maxTrans;
    }

    public int getTransRes() {
        return transRes;
    }
    public boolean resDIas(){
        return true;
    }
    @Override
    public boolean isvalida() {
        
        if( transaccionesArrayList.size()<maxTrans && resDIas()==true){
        return true;
        }
        return false;
    }
    @Override
    public String toString(){
        String retorno=super.toString();
        retorno+=" transaciones totales :"+this.maxTrans+" restantes :"+(maxTrans-transaccionesArrayList.size());
        return retorno;
        
    }

    
    @Override
    protected Licencia_limitada clone()  {
        Licencia_limitada nueva = new Licencia_limitada(this.maxTrans, this.transRes,this.email , this.servicio, this.fechaCracion, this.codigo,this.revocada, this.transacciones, this.transaccionesArrayList);
        
        return nueva; 
    }
    
    
}
