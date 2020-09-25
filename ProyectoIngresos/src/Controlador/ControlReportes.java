
package Controlador;

import MapeoJPA.Entradassalidas;
import MapeoJPA.Novedades;
import MapeoJPA.persistencia.DAOFactory;
import Modelo.ModeloReportes;
import Vista.Dialogos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ControlReportes {
    
    public void buscarpersonas(ModeloReportes mr)throws Exception{
        int i = 0;
        Row llenar[];
        if(mr == null){
            throw new Exception("No hay datos a buscar, por favor ingrese todos los datos");
        }
        
        if("".equals(mr.getFechad())){
            throw new Exception("La fecha de inicio es obligatoria");
        }
        
        if("".equals(mr.getFechah())){
            throw new Exception("La fecha de finalizacion es obligatoria");
        }
        
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Movimiento de personas");
        
        Row row = sheet.createRow(1);
        row.createCell(1).setCellValue("ID E/S");
        row.createCell(2).setCellValue("Fecha");
        row.createCell(3).setCellValue("Hora entrada");
        row.createCell(4).setCellValue("Hora salida");
        row.createCell(5).setCellValue("Temperatura");
        row.createCell(6).setCellValue("C.C usuario");
        row.createCell(7).setCellValue("C.C personal");
        
        
        try {
            verificarfechas(mr);
            Date start = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(mr.getFechad());
            Date end = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(mr.getFechah());
            
            List<Entradassalidas> es = DAOFactory.getEntradassalidasDAO().consultar();     
            llenar = new Row[es.size()];
            
            for (Entradassalidas es1 : es) {
                if(es1.getFecha().compareTo(end)> 0 || es1.getFecha().compareTo(start)<0){
                }else{
                    llenar[i] = sheet.createRow(2+i);
                    llenar[i].createCell(1).setCellValue(es1.getIDEntradaSalida());
                    String fecha = new SimpleDateFormat("yyyy/MM/dd").format(es1.getFecha());
                    llenar[i].createCell(2).setCellValue(fecha);
                    String hora1 = new SimpleDateFormat("HH:mm").format(es1.getHoraEntrada());
                    llenar[i].createCell(3).setCellValue(hora1);
                    String hora2 = new SimpleDateFormat("HH:mm").format(es1.getHoraSalida());
                    llenar[i].createCell(4).setCellValue(hora2);
                    llenar[i].createCell(5).setCellValue(es1.getTemperatura());
                    llenar[i].createCell(6).setCellValue(es1.getCedulaUsuario().getCedulaUsuarios());
                    llenar[i].createCell(7).setCellValue(es1.getCedulaPersonal().getCedulaPersonal());
                    i++;
                }
                
            }
           
            FileOutputStream fileout = new FileOutputStream("Cantidad de personas.xlsx");
            book.write(fileout);
            fileout.close();  
            
            String mensaje = "Reporte creado correctamente";
            Dialogos d = new Dialogos(null, mensaje, "");
            d.setVisible(true);
        }catch (ParseException ex) 
        {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void buscarcontagiados(ModeloReportes mr) throws Exception{
        int i = 0;
        Row llenar[];
        if(mr == null){
            throw new Exception("No hay datos a buscar, por favor ingrese todos los datos");
        }
        
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Cantidad de contagiados");
        
        Row row = sheet.createRow(1);
        row.createCell(1).setCellValue("ID novedad");
        row.createCell(2).setCellValue("Temperatura");
        row.createCell(3).setCellValue("Enfermedades");
        row.createCell(4).setCellValue("ConviveME");
        row.createCell(5).setCellValue("Ultimo sitio");
        row.createCell(6).setCellValue("C.C usuario");
        row.createCell(7).setCellValue("C.C personal");
        
        
        try {
            
            List<Novedades> es = DAOFactory.getNovedadesDAO().consultar();     
            llenar = new Row[es.size()];
            
            for (Novedades n : es) {
                    llenar[i] = sheet.createRow(2+i);
                    llenar[i].createCell(1).setCellValue(n.getIDNovedad());
                    llenar[i].createCell(2).setCellValue(n.getTemperatura());
                    llenar[i].createCell(3).setCellValue(n.getEnfermedades());
                    llenar[i].createCell(4).setCellValue(n.getConviveME());
                    llenar[i].createCell(5).setCellValue(n.getUltimoSitio());
                    llenar[i].createCell(6).setCellValue(n.getCedulaUsuario().getCedulaUsuarios());
                    llenar[i].createCell(7).setCellValue(n.getCedulaPersonal().getCedulaPersonal());
                    i++;
                
                
            }
           
            FileOutputStream fileout = new FileOutputStream("Contagiados.xlsx");
            book.write(fileout);
            fileout.close();  
            
            String mensaje = "Reporte creado correctamente";
            Dialogos d = new Dialogos(null, mensaje, "");
            d.setVisible(true);
        }catch (ParseException ex) 
        {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void verificarfechas(ModeloReportes mr)throws Exception{
        try {
        Date start = new SimpleDateFormat("yyyy/MM/dd").parse(mr.getFechad());
        Date end = new SimpleDateFormat("yyyy/MM/dd").parse(mr.getFechah());

        
        if(start.compareTo(end) > 0){
            throw new Exception("La fecha de inicio esta despues de la fecha de finalizacion");
        }
        }catch (ParseException ex) 
        {
            System.out.println(ex);
        }
       
    }
    
    
}
