package Modelo;

public class ModeloLogeo {
    
    private String username,contraseña;

    public ModeloLogeo(String username, String contraseña) {
        this.username = username;
        this.contraseña = contraseña;
    }

    public ModeloLogeo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
