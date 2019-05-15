/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.de.fechas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Licencia_limitada_dia extends Licencia_limitada{
    protected final int limiteDia;
    protected int transDia;
    protected Map<LocalDate, Integer>  mapa = new HashMap<>();;

    public Licencia_limitada_dia(int limiteDia, int maxTrans, String email, String servicio) {
        super(maxTrans, email, servicio);
        this.limiteDia = limiteDia;
    }
     protected Licencia_limitada_dia(int limiteDia,int maxTrans, int transRes,String email , String servicio, LocalDate fechaCreacion, String codigo,boolean revocada, int transacciones, ArrayList<Transaccion> transaccionesArrayList, Map<LocalDate, Integer> mapa ) {
        super( maxTrans,  transRes,email , servicio,  fechaCreacion, codigo, revocada, transacciones, transaccionesArrayList);
        this.mapa.putAll(mapa);
        this.limiteDia = limiteDia;
    }
    @Override
    public boolean resDIas(){
        if(!mapa.containsKey(LocalDate.now())){
            this.transDia=0;
        }
        if(limiteDia>transDia){
            transDia++;
            AgregarMap();
            return true;
        }       
        return false;
    }
    @Override
    public int restantes(){
        if(mapa.containsKey(LocalDate.now())){
             return limiteDia-mapa.get(LocalDate.now());
         }
         return limiteDia;
        
    }
    public int restantes(LocalDate dia){
         if(mapa.containsKey(dia)){
             return limiteDia-mapa.get(dia);
         }
         return limiteDia;
    }
    
    public void AgregarMap(){
        LocalDate hoy= LocalDate.now();
        mapa.remove(hoy);
        mapa.put( hoy, transDia );   
    }

    @Override
    protected Licencia_limitada_dia clone()  {
        Licencia_limitada_dia nuevo = new Licencia_limitada_dia(limiteDia, maxTrans, transRes, email, servicio, fechaCracion, codigo, revocada, transacciones, transaccionesArrayList, mapa);
        return nuevo; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public String toString(){
        String retorno=super.toString();
        retorno+=" Maxima transacciones por dia: "+this.limiteDia+" hoy se han hecho "+this.transDia;
        return retorno;
    }
  
    
}
