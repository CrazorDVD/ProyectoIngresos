package Modelo;


public class ModeloEliminar {
    
    private String cedula,tipodoc,nombre,apellido,carnet;

    public ModeloEliminar(String cedula, String tipodoc, String nombre, String apellido, String carnet) {
        this.cedula = cedula;
        this.tipodoc = tipodoc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carnet = carnet;
    }

    public ModeloEliminar() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
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

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
    
}
