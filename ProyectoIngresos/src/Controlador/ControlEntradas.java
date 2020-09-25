package Controlador;

import MapeoJPA.Entradassalidas;
import MapeoJPA.Personal;
import MapeoJPA.Programas;
import MapeoJPA.Usuarios;
import MapeoJPA.persistencia.DAOFactory;
import static MapeoJPA.persistencia.DAOFactory.getEntradassalidasDAO;
import MapeoJPA.persistencia.EntityManagerHelper;
import Modelo.ModeloEntradas;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ControlEntradas {
    public void buscar(ModeloEntradas entradas) throws Exception{
        if(entradas == null){
            throw new Exception("No hay datos a buscar, por favor ingrese todos los datos");
        }
        if(entradas.getCedula() == 0){
            throw new Exception("El documento es un dato obligatorio");
        }
        boolean encontro = false;
        boolean salida = false;
        int codigo = 1;
        try {
            List<Usuarios> usuario = DAOFactory.getUsuariosDAO().consultar();
            for (Usuarios usuario1 : usuario) {
                if (entradas.getCedula() == usuario1.getCedulaUsuarios()) {
                    encontro = true;
                    List<Entradassalidas> es = DAOFactory.getEntradassalidasDAO().consultar();
                    for (Entradassalidas es1 : es) {
                        String fech;
                        Date fecha = new Date();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
                        fech = formato.format(es1.getFecha());
                        
                        if (entradas.getFecha().equals(fech) && entradas.getCedula() == es1.getCedulaUsuario().getCedulaUsuarios()) {
                            
                            codigo = es1.getIDEntradaSalida();
                        }
                    }
                }
            }
            List<Entradassalidas> es = DAOFactory.getEntradassalidasDAO().consultar();
            if (codigo != 1) {
                for (Entradassalidas es1 : es) {
                    String hora = "" + es1.getHoraSalida();
                    if (codigo == es1.getIDEntradaSalida() && !hora.equals("null")) {
                        for (Usuarios usuario1 : usuario) {
                            if (usuario1.getCedulaUsuarios() == entradas.getCedula()) {
                                if(usuario1.getEliminado().equals("SI")){
                                    throw new Exception("El usuario no existe (inactivo)");
                                }
                                salida = true;
                                entradas.setTipodoc(usuario1.getTipoDocumento());
                                entradas.setNombre(usuario1.getNombre());
                                entradas.setApellido(usuario1.getApellido());
                                entradas.setTelefono(usuario1.getTelefono());
                                entradas.setDireccion(usuario1.getDireccion());
                                entradas.setCiudad(usuario1.getCiudad());
                                entradas.setCargo(usuario1.getCargo());
                                entradas.setPrograma("" + usuario1.getIDPrograma().getNombre());
                            }
                        }
                    }
                }
            } else {
                for (Usuarios usuario1 : usuario) {
                    if (usuario1.getCedulaUsuarios() == entradas.getCedula()) {
                        if(usuario1.getEliminado().equals("SI")){
                                    throw new Exception("El usuario no existe (inactivo)");
                                }
                        salida = true;
                        entradas.setTipodoc(usuario1.getTipoDocumento());
                        entradas.setNombre(usuario1.getNombre());
                        entradas.setApellido(usuario1.getApellido());
                        entradas.setTelefono(usuario1.getTelefono());
                        entradas.setDireccion(usuario1.getDireccion());
                        entradas.setCiudad(usuario1.getCiudad());
                        entradas.setCargo(usuario1.getCargo());
                        entradas.setPrograma("" + usuario1.getIDPrograma().getNombre());
                    }
                }
            }
            
            if(encontro==false){
                throw new Exception("El usuario no existe");
            }
            if(salida==false){
                throw new Exception("El usuario no registra salida");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    } 

    public void crearEntrada(ModeloEntradas me) throws Exception{
        
        if("".equals(me.getTemperatura())){
            throw new Exception("Por favor ingrese la temperatura");
        }
        
        try {
            
            Date fecha = null;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            fecha = formato.parse(me.getFecha());
            Date hora = null;
            SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
            hora = formatohora.parse(me.getHora());
            
            List<Usuarios> us = DAOFactory.getUsuariosDAO().consultar();
            List<Personal> pl = DAOFactory.getPersonalDAO().consultar();
            Usuarios users = new Usuarios();
            Personal pers = new Personal();
            for (Usuarios us1 : us) {
                        if (me.getCedula()==us1.getCedulaUsuarios()) {
                           users = us1;
                        }
                    }
            for (Personal pl1 : pl) {
                        if (me.getCedulafuncionario()==pl1.getCedulaPersonal()) {
                           pers = pl1;
                        }
                    }
            
            Entradassalidas es = new Entradassalidas();
            es.setFecha(fecha);
            es.setHoraEntrada(hora);
            es.setTemperatura(me.getTemperatura());
            es.setCedulaUsuario(users);
            es.setCedulaPersonal(pers);
            EntityManagerHelper.beginTransaction();
            DAOFactory.getEntradassalidasDAO().insertar(es);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void crearUsuario(ModeloEntradas entradas) throws Exception {
        if(entradas == null){
            throw new Exception("No hay datos a buscar, por favor ingrese todos los datos");
        }
        if(entradas.getCedula() == 0){
            throw new Exception("El documento es un dato obligatorio");
        }
        if("".equals(entradas.getNombre())){
            throw new Exception("El nombre es un dato obligatorio");
        }
        if("".equals(entradas.getApellido())){
            throw new Exception("El apellido es un dato obligatorio");
        }
        if("".equals(entradas.getTelefono())){
            throw new Exception("El telefono es un dato obligatorio");
        }
        if("".equals(entradas.getDireccion())){
            throw new Exception("La direccion es un dato obligatorio");
        }
        if("".equals(entradas.getCiudad())){
            throw new Exception("La ciudad es un dato obligatorio");
        }
        if("".equals(entradas.getCorreo())){
            throw new Exception("El correo es un dato obligatorio");
        }
        if("".equals(entradas.getCarnet())){
            throw new Exception("El carnet es un dato obligatorio");
        }
        Programas pg = new Programas();
        int progcod;
        if(entradas.getPrograma().equals("Ing Industrial")){
            pg = DAOFactory.getProgramasDAO().consultarporid(3751);
        }
        if(entradas.getPrograma().equals("Lic Historia")){
            pg = DAOFactory.getProgramasDAO().consultarporid(3251);
        }
        if(entradas.getPrograma().equals("Musica")){
            pg = DAOFactory.getProgramasDAO().consultarporid(3552);
        }
        if(entradas.getPrograma().equals("Psicologia")){
            pg = DAOFactory.getProgramasDAO().consultarporid(3461);
        }
        if(entradas.getPrograma().equals("Tec Electronica")){
            pg = DAOFactory.getProgramasDAO().consultarporid(2710);
        }
        if(entradas.getPrograma().equals("Tec Sitemas")){
            pg = DAOFactory.getProgramasDAO().consultarporid(2711);
        }
        
        Usuarios user = new Usuarios();
        
        user.setCedulaUsuarios(Integer.parseInt(""+entradas.getCedula()));
        user.setTipoDocumento(entradas.getTipodoc());
        user.setNombre(entradas.getNombre());
        user.setApellido(entradas.getApellido());
        user.setTelefono(entradas.getTelefono());
        user.setDireccion(entradas.getDireccion());
        user.setCiudad(entradas.getCiudad());
        user.setCorreo(entradas.getCorreo());
        user.setCargo(entradas.getCargo());
        user.setIDPrograma(pg);
        user.setEliminado("NO");
        user.setCarnet(entradas.getCarnet());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUsuariosDAO().insertar(user);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

}
