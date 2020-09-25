/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA.persistencia;

import MapeoJPA.Programas;
import MapeoJPA.Usuarios;
import java.util.List;

/**
 *
 * @author Andres Daraviña
 */
public interface IUsuariosDAO {
    public void insertar(Usuarios usuarios) throws Exception;
    public void modificar(Usuarios usuarios) throws Exception;
    public void eliminar(Usuarios usuarios) throws Exception;
    public Usuarios consultarporid(Integer cedulaUsuarios) throws Exception;
    public List<Usuarios> consultar() throws Exception;
}
