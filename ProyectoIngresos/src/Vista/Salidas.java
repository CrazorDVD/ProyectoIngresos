/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControlEntradas;
import Controlador.ControlSalidas;
import Modelo.ModeloEntradas;
import Modelo.ModeloSalidas;
import Utileria.Utilhora;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author Andres Daraviña
 */
public class Salidas extends javax.swing.JDialog {
    
    String nombre1,cedula;
    Salidas(Menu sc,String nombre,String cedula) {
        super(sc,true);
        this.nombre1 = nombre;
        this.cedula = cedula;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        codigous = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        buscar4 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        tipodoc = new javax.swing.JTextField();
        nombres = new javax.swing.JTextField();
        apellidos = new javax.swing.JTextField();
        telefonos = new javax.swing.JTextField();
        direcciones = new javax.swing.JTextField();
        ciudades = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        cancelar1 = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        cargos = new javax.swing.JComboBox<>();
        fechas = new javax.swing.JFormattedTextField();
        horas = new javax.swing.JFormattedTextField();
        programas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Salida de Usuarios");
        setResizable(false);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/barrahorilarg.png"))); // NOI18N
        jPanel14.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 10));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Salida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel74.setText("Codigo Encargado:");
        jPanel15.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel75.setText("Documento Usuario");
        jPanel15.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        codigous.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codigous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigousActionPerformed(evt);
            }
        });
        jPanel15.add(codigous, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 73, 99, -1));

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel76.setText("Id");
        jPanel15.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));
        jLabel76.setText(nombre1);

        buscar4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/buscar.png"))); // NOI18N
        buscar4.setText("Buscar");
        buscar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar4ActionPerformed(evt);
            }
        });
        jPanel15.add(buscar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 68, -1, -1));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel92.setText("Tipo Documento");
        jPanel16.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 21, -1, -1));

        tipodoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel16.add(tipodoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 18, 118, -1));
        tipodoc.setEditable(false);

        nombres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel16.add(nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 59, 162, -1));
        nombres.setEditable(false);

        apellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel16.add(apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 100, 162, -1));
        apellidos.setEditable(false);

        telefonos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel16.add(telefonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 140, 162, -1));
        telefonos.setEditable(false);

        direcciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel16.add(direcciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 181, 162, -1));
        direcciones.setEditable(false);

        ciudades.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel16.add(ciudades, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 223, 162, -1));
        ciudades.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nombre");
        jPanel16.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 62, -1, -1));

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel80.setText("Apellido");
        jPanel16.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 101, -1, -1));

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel81.setText("Telefono");
        jPanel16.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 146, -1, -1));

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setText("Direccion");
        jPanel16.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 184, -1, -1));

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel83.setText("Ciudad");
        jPanel16.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 226, -1, -1));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel94.setText("Cargo");
        jPanel16.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 62, -1, -1));

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel95.setText("Programa");
        jPanel16.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 104, -1, -1));

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel96.setText("Hora:");
        jPanel16.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 184, -1, -1));

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel97.setText("Fecha:");
        jPanel16.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 143, -1, -1));

        cancelar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/eliminar.png"))); // NOI18N
        cancelar1.setText("Cancelar");
        cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar1ActionPerformed(evt);
            }
        });
        jPanel16.add(cancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 222, -1, -1));
        cancelar1.setEnabled(false);

        aceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/Ok-icon.png"))); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        jPanel16.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 222, -1, -1));
        aceptar.setEnabled(false);

        cargos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Docente", "Administrativo", "Visitante" }));
        jPanel16.add(cargos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 59, 110, -1));
        cargos.setEnabled(false);

        try {
            fechas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fechas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel16.add(fechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 110, -1));
        fechas.setText(Utilhora.getinstance().getDateFecha());
        fechas.setEditable(false);

        try {
            horas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        horas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel16.add(horas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 181, 110, -1));
        horas.setText(Utilhora.getinstance().getDateHour());
        horas.setEditable(false);

        programas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        programas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Ing Industrial", "Lic Historia", "Musica", "Psicologia", "Tec Electronica", "Tec Sitemas" }));
        jPanel16.add(programas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 110, -1));
        programas.setEnabled(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/fondo1.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(600, 486));
        jPanel16.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -130, 610, 450));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 119, 520, 260));

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setText("Nombre");
        jPanel15.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));
        jLabel77.setText(cedula);

        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/univalleR.png"))); // NOI18N
        jPanel15.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 19, -1, -1));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel79.setText("Nombre Encargado:");
        jPanel15.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/fondo1.png"))); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(600, 486));
        jPanel15.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 620, 450));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, 560, 400));

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/barrahorilarg.png"))); // NOI18N
        jPanel14.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 453, 600, -1));

        volver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/back-icon.png"))); // NOI18N
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel14.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 419, -1, -1));
        cancelar1.setEnabled(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/fondo1.png"))); // NOI18N
        jPanel14.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 600, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 594, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void codigousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigousActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigousActionPerformed

    private void buscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar4ActionPerformed
        
        try {
            ModeloSalidas ms = new ModeloSalidas();
            ms.setCedula(Long.parseLong(codigous.getText()));
            ms.setFecha(fechas.getText());
            ControlSalidas cs = new ControlSalidas();
            cs.buscar(ms);
            tipodoc.setText(ms.getTipodoc());
            nombres.setText(ms.getNombre());
            apellidos.setText(ms.getApellido());
            telefonos.setText(ms.getTelefono());
            direcciones.setText(ms.getDireccion());
            ciudades.setText(ms.getCiudad());
            cargos.setSelectedItem(ms.getCargo());
            programas.setSelectedItem(ms.getPrograma());
            aceptar.setEnabled(true);
            cancelar1.setEnabled(true);
        }
        catch (NumberFormatException ex1) {
            Dialogos dg = new Dialogos(null,"Debe ingresar un valor numerico","");
            dg.setVisible(true);
        }
        catch (Exception ex) {
            Dialogos dg = new Dialogos(null,ex.getMessage(),"");
            dg.setVisible(true);
            
        }
    }//GEN-LAST:event_buscar4ActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar1ActionPerformed
        tipodoc.setText("");
        nombres.setText("");
        apellidos.setText("");
        telefonos.setText("");
        direcciones.setText("");
        ciudades.setText("");
        cargos.setSelectedItem("Estudiante");
        programas.setSelectedItem("Ninguno");
        codigous.requestFocus();
        aceptar.setEnabled(false);
        cancelar1.setEnabled(false);
    }//GEN-LAST:event_cancelar1ActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        
        try {
            ModeloEntradas me = new ModeloEntradas();
            me.setFecha(fechas.getText());
            me.setHora(horas.getText());
            me.setCedula(Long.parseLong(codigous.getText()));
            me.setCedulafuncionario(Long.parseLong(jLabel76.getText()));
            ControlSalidas ce = new ControlSalidas();
            ce.crearEntrada(me);
            Dialogos dg = new Dialogos(null,"La salida fue realizada","satisfactoriamente");
            dg.setVisible(true);
            dispose();
        } catch (Exception e) {
            Dialogos dg = new Dialogos(null,e.getMessage(),"");
            dg.setVisible(true);
        }
        
    }//GEN-LAST:event_aceptarActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JTextField apellidos;
    private javax.swing.JButton buscar4;
    private javax.swing.JButton cancelar1;
    private javax.swing.JComboBox<String> cargos;
    private javax.swing.JTextField ciudades;
    private javax.swing.JTextField codigous;
    private javax.swing.JTextField direcciones;
    private javax.swing.JFormattedTextField fechas;
    private javax.swing.JFormattedTextField horas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JTextField nombres;
    private javax.swing.JComboBox<String> programas;
    private javax.swing.JTextField telefonos;
    private javax.swing.JTextField tipodoc;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
