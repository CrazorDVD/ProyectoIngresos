/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA.persistencia;

import MapeoJPA.Programas;
import java.util.List;

/**
 *
 * @author Andres Daraviña
 */
public interface IProgramasDAO {
    public void insertar(Programas programas) throws Exception;
    public void modificar(Programas programas) throws Exception;
    public void eliminar(Programas programas) throws Exception;
    public Programas consultarporid(Integer iDPrograma) throws Exception;
    public List<Programas> consultar() throws Exception;
}
