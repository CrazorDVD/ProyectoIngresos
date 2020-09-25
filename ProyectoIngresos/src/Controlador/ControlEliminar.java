package Controlador;

import MapeoJPA.Usuarios;
import MapeoJPA.persistencia.DAOFactory;
import MapeoJPA.persistencia.EntityManagerHelper;
import Modelo.ModeloEliminar;

public class ControlEliminar {

    
    public void buscarUsuario(ModeloEliminar me) throws Exception {
        if(me == null){
            throw new Exception("No hay datos a buscar, por favor ingrese todos los datos");
        }
        if("".equals(me.getCedula())){
            throw new Exception("El documento es un dato obligatorio");
        }
        Usuarios us = new Usuarios();
        us = DAOFactory.getUsuariosDAO().consultarporid(Integer.parseInt(me.getCedula()));
        String probar = ""+us;
        if (!probar.equals("null")) {
            if(us.getEliminado().equals("NO")){
            me.setNombre(us.getNombre());
            me.setApellido(us.getApellido());
            me.setTipodoc(us.getTipoDocumento());
            me.setCarnet(us.getCarnet());
            }else{
                throw new Exception("El usuario ya se encuentra eliminado");
            }
        }else{
            throw new Exception("El usuario no existe");
        }
    }

    public void eliminarUsuario(ModeloEliminar me) throws Exception {
         
            Usuarios us = new Usuarios();
            us = DAOFactory.getUsuariosDAO().consultarporid(Integer.parseInt(me.getCedula()));
            us.setEliminado("SI");
            
            EntityManagerHelper.beginTransaction();
            DAOFactory.getUsuariosDAO().modificar(us);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        
    }
    
}
