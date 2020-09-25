/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA.persistencia;

import MapeoJPA.Novedades;
import java.util.List;

/**
 *
 * @author Andres Daraviña
 */
public interface INovedadesDAO {
    public void insertar(Novedades novedades) throws Exception;
    public void modificar(Novedades novedades) throws Exception;
    public void eliminar(Novedades novedades) throws Exception;
    public Novedades consultarporid(Integer iDNovedad) throws Exception;
    public List<Novedades> consultar() throws Exception;
}
