package Controlador;

import MapeoJPA.Personal;
import MapeoJPA.persistencia.DAOFactory;
import Modelo.ModeloLogeo;
import java.util.List;

public class ControlLogeo {
    
    public String cedula = "",nombre = "";
    
    public void logeo(ModeloLogeo logeo) throws Exception{
        
        if(logeo == null){
            throw new Exception("No hay datos a buscar, por favor ingrese todos los datos");
        }
        if("".equals(logeo.getUsername())){
            throw new Exception("El nickname es un dato obligatorio");
        }
        if("".equals(logeo.getContraseña())){
            throw new Exception("La contraseña es un dato obligatorio");
        }
        boolean encontro = false;
        try {
            List<Personal> personal = DAOFactory.getPersonalDAO().consultar();
            for (Personal personal1 : personal) {
                if(logeo.getUsername().equals(personal1.getUsername())&&logeo.getContraseña().equals(personal1.getContraseña())){
                     encontro = true;
                     cedula=""+personal1.getCedulaPersonal();
                     nombre=personal1.getNombre();
                }
            }
        } catch (Exception e) {
        }
        if(encontro==false){
            throw new Exception("Logeo Fallido");
        }
        
    }
}
