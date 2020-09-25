package Controlador;

import MapeoJPA.Novedades;
import MapeoJPA.Personal;
import MapeoJPA.Usuarios;
import MapeoJPA.persistencia.DAOFactory;
import MapeoJPA.persistencia.EntityManagerHelper;
import Modelo.ModeloNovedad;
import Vista.Novedad;
import java.awt.Panel;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ControlNovedad {

    public void crearNovedad(ModeloNovedad mn) throws Exception {
        
        if(mn == null){
            throw new Exception("No hay datos a buscar, por favor ingrese todos los datos");
        }
        if("".equals(mn.getEnfermedades())){
            mn.setEnfermedades("Ninguna");
        }
        if("".equals(mn.getUltimositio())){
            throw new Exception("Debe ingresar el ultimo sitio visitado");
        }
        
        Personal per = new Personal();
        Usuarios us = new Usuarios();
        per = DAOFactory.getPersonalDAO().consultarporid(Integer.parseInt(mn.getCedulafunc()));
        us = DAOFactory.getUsuariosDAO().consultarporid(Integer.parseInt(mn.getDocumento()));
        
        Novedades nv = new Novedades();
        nv.setCedulaUsuario(us);
        nv.setCedulaPersonal(per);
        nv.setConviveME(mn.getConviveme());
        nv.setEnfermedades(mn.getEnfermedades());
        nv.setTemperatura(Integer.parseInt(mn.getTemperatura()));
        nv.setUltimoSitio(mn.getUltimositio());
        
            EntityManagerHelper.beginTransaction();
            DAOFactory.getNovedadesDAO().insertar(nv);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        
            enviarCorreo(per.getCorreo(),mn,nv,us);
    }

    private void enviarCorreo(String correo, ModeloNovedad mn, Novedades nv, Usuarios us) {
        
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth","true");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        //EL correo que envia los mensajes en las comillas 
        String correoEnvia = "proyectoentrasasalidad@gmail.com";
        //La contraseña en las comillas 
        String contrasena = "proyectoentradasalida";
        MimeMessage mail = new MimeMessage(sesion);
        String mensaje = "Se ha registrado una novedad de alta temperatura en el estudiante "+us.getNombre()+" con una temperatura de "+nv.getTemperatura()+" grados "+
                         "el usuario se encuentra registrado con los siguientes datos\nNombre: "+us.getNombre()+"\nApellido: "+us.getApellido()+"\n"+
                         "Telefono:"+us.getTelefono()+"\nCiudad: "+us.getCiudad()+"\nDireccion: "+us.getDireccion()+"\nCargo: "+us.getCargo()+"\n"+
                         "Programa: "+us.getIDPrograma().getNombre()+"\nEl usuario registra las siguientes enfermedades:\n"+mn.getEnfermedades()+"\n"+
                         "Convive con Menores de edad?: "+mn.getConviveme()+"\nUltimo sitio visitado: "+mn.getUltimositio();
        try {
            String[] correos = {correo,"andres.daravina@correounivalle.edu.co","juan.osorio.monsalve@correounivalle.edu.co","juan.rodriguez.penagos@correounivalle.edu.co"};
            for (int i = 0; i < correos.length; i++) {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (correos[i]));
            mail.setSubject("Novedad Ingreso Estudiante");
            mail.setText(mensaje);
            
            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
                System.out.println("correo "+i);
            }
            
 
        } catch (AddressException ex) {
            System.out.println("lel");
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.mail.MessagingException ex) {
            Logger.getLogger(Novedad.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
    
}
