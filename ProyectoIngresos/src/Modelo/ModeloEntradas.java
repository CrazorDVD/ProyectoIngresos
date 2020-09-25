package Modelo;

import javax.swing.JTable;

public class ModeloEntradas {
    
    private long cedula;
    private long cedulafuncionario;
    private String nombre;
    private String apellido;
    private String tipodoc;
    private String telefono;
    private String ciudad;
    private String direccion;
    private String cargo;
    private String correo;
    private String carnet;
    private String programa;
    private String hora;
    private String fecha;
    private String temperatura;

    public ModeloEntradas(long cedula, long cedulafuncionario, String nombre, String apellido, String tipodoc, String telefono, String ciudad, String direccion, String cargo, String correo, String carnet, String programa, String hora, String fecha, String temperatura) {
        this.cedula = cedula;
        this.cedulafuncionario = cedulafuncionario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipodoc = tipodoc;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.cargo = cargo;
        this.correo = correo;
        this.carnet = carnet;
        this.programa = programa;
        this.hora = hora;
        this.fecha = fecha;
        this.temperatura = temperatura;
    }

    public ModeloEntradas() {
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public long getCedulafuncionario() {
        return cedulafuncionario;
    }

    public void setCedulafuncionario(long cedulafuncionario) {
        this.cedulafuncionario = cedulafuncionario;
    }
}
