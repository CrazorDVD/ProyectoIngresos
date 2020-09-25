package Controlador;

import MapeoJPA.Entradassalidas;
import MapeoJPA.Personal;
import MapeoJPA.Usuarios;
import MapeoJPA.persistencia.DAOFactory;
import MapeoJPA.persistencia.EntityManagerHelper;
import Modelo.ModeloEntradas;
import Modelo.ModeloSalidas;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ControlSalidas {

     public void buscar(ModeloSalidas salidas) throws Exception{
        if(salidas == null){
            throw new Exception("No hay datos a buscar, por favor ingrese todos los datos");
        }
        if(salidas.getCedula() == 0){
            throw new Exception("El documento es un dato obligatorio");
        }
        boolean encontro = false;
        int codigo = 0;
        try {
            List<Usuarios> usuario = DAOFactory.getUsuariosDAO().consultar();
            for (Usuarios usuario1 : usuario) {
                if (salidas.getCedula() == usuario1.getCedulaUsuarios()) {
                    List<Entradassalidas> es = DAOFactory.getEntradassalidasDAO().consultar();
                    for (Entradassalidas es1 : es) {
                        String fech;
                        Date fecha = new Date();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
                        fech = formato.format(es1.getFecha());
                        if (salidas.getFecha().equals(fech) && salidas.getCedula() == es1.getCedulaUsuario().getCedulaUsuarios()) {
                            
                            codigo = es1.getIDEntradaSalida();
                            
                        }
                    }
                }
            }
            
            List<Entradassalidas> es = DAOFactory.getEntradassalidasDAO().consultar();
            for (Entradassalidas es1 : es) {
                String hora = ""+es1.getHoraSalida();
                if (codigo == es1.getIDEntradaSalida() && hora.equals("null")) {
                    for (Usuarios usuario1 : usuario) {
                        if (usuario1.getCedulaUsuarios() == salidas.getCedula()) {
                        encontro = true;
                        salidas.setTipodoc(usuario1.getTipoDocumento());
                        salidas.setNombre(usuario1.getNombre());
                        salidas.setApellido(usuario1.getApellido());
                        salidas.setTelefono(usuario1.getTelefono());
                        salidas.setDireccion(usuario1.getDireccion());
                        salidas.setCiudad(usuario1.getCiudad());
                        salidas.setCargo(usuario1.getCargo());
                        salidas.setPrograma(usuario1.getIDPrograma().getNombre());
                    }
                    }
                }
            }
            if (encontro == false) {
                throw new Exception("El usuario no presenta entrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
     
        public void crearEntrada(ModeloEntradas me) throws Exception{
        
        try{
            Date fecha = null;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            fecha = formato.parse(me.getFecha());
            
            Date hora = null;
            SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
            hora = formatohora.parse(me.getHora());
            
            List<Entradassalidas> entsal = DAOFactory.getEntradassalidasDAO().consultar();
            Entradassalidas ess = new Entradassalidas();
            
            for (Entradassalidas entsal1 : entsal) {
                String horas = "" + entsal1.getHoraSalida();
                        if (me.getCedula()==entsal1.getCedulaUsuario().getCedulaUsuarios() && entsal1.getFecha().equals(fecha) && horas.equals("null")) {
                           ess = entsal1;
                           ess.setHoraSalida(hora);
                        }
                    }
            EntityManagerHelper.beginTransaction();
            DAOFactory.getEntradassalidasDAO().modificar(ess);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
