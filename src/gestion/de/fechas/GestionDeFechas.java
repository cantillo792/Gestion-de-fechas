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
public class GestionDeFechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        // TODO code application logic here
        LocalDate Fcaduca = LocalDate.of(2019, 6, 14);
        Licencia_temporal licencia_temporal=new Licencia_temporal( Fcaduca,"juan@um.es", "http://api.um.es/disco/v1/");
        Licencia_limitada licencia_limitada= new Licencia_limitada(3, "pepe@um.es", "http://api.um.es/disco/v1/");
        Licencia_limitada_dia licencia_limitada_dia= new Licencia_limitada_dia(1,4,"paco@um.es","http://api.um.es/disco/v1/");
        ArrayList<Licencia> lista= new ArrayList<>();
        lista.add(licencia_temporal);
        lista.add(licencia_limitada);
        lista.add(licencia_limitada_dia);
        for (Licencia licencia : lista) {
            System.out.println(licencia.toString()+"\n");
        }
        for (int i = 0; i <lista.size(); i++) {
            
            if(Licencia_limitada_dia.class== lista.get(i).getClass() ){
               System.out.println(lista.get(i).restantes()+"\n");
            }
            if(lista.get(i).getClass()== licencia_temporal.getClass()){
               lista.get(i).revocar();
            }
            
        }
         for (Licencia licencia : lista) {
             for (int i = 0; i < 4; i++) {
                 
             
             Transaccion salida = licencia.autorizacion();
             if(salida!=null){
                 System.out.println(salida.toString()+"\n");
             }else{
                 System.out.println("no autorizado \n");
             }
             
             }
           
        }
         for (Licencia licencia : lista) {
            System.out.println(licencia.toString()+"\n");
        }
         ArrayList<Licencia> copias = new ArrayList<>();
        for (Licencia licencia : lista){
            copias.add(licencia.clone());
            
        }
        for (Licencia licencia : copias) {
            System.out.println(licencia.toString()+"\n");
        }  
        
    }
    
}
