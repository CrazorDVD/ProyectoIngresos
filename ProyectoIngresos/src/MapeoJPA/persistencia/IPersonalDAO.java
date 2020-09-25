/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA.persistencia;

import MapeoJPA.Personal;
import java.util.List;

/**
 *
 * @author Andres Daraviña
 */
public interface IPersonalDAO {
    public void insertar(Personal personal) throws Exception;
    public void modificar(Personal personal) throws Exception;
    public void eliminar(Personal personal) throws Exception;
    public Personal consultarporid(Integer cedulaPersonal) throws Exception;
    public List<Personal> consultar() throws Exception;
}
