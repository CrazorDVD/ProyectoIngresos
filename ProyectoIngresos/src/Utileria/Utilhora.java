package Utileria;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilhora {

    private static Utilhora instance  = null;
    
    
    public static Utilhora getinstance(){
        if(instance == null){
           instance = new Utilhora(); 
           
           
        }
        return instance;
    }
    
    public String getDateHour(){
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        return formato.format(fechaActual);
    }
    public String getDateFecha(){
            Date fechaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            return formato.format(fechaActual);
        }
    
}
