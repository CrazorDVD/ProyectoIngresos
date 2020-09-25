/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA.persistencia;

import MapeoJPA.Entradassalidas;
import java.util.List;

/**
 *
 * @author Andres Daraviña
 */
public interface IEntradassalidasDAO {
    public void insertar(Entradassalidas entradassalidas) throws Exception;
    public void modificar(Entradassalidas entradassalidas) throws Exception;
    public void eliminar(Entradassalidas entradassalidas) throws Exception;
    public Entradassalidas consultarporid(Integer iDEntradaSalida) throws Exception;
    public List<Entradassalidas> consultar() throws Exception;
}
