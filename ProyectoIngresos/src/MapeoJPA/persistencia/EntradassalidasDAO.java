/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA.persistencia;

import MapeoJPA.Entradassalidas;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Andres Daraviña
 */
public class EntradassalidasDAO implements IEntradassalidasDAO{

    @Override
    public void insertar(Entradassalidas entradassalidas) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(entradassalidas);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Entradassalidas entradassalidas) throws Exception {
    try {
            EntityManagerHelper.getEntityManager().merge(entradassalidas);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Entradassalidas entradassalidas) throws Exception {
    try {
            EntityManagerHelper.getEntityManager().remove(entradassalidas);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Entradassalidas consultarporid(Integer iDEntradaSalida) throws Exception {
    try {
           return EntityManagerHelper.getEntityManager().find(Entradassalidas.class, iDEntradaSalida);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Entradassalidas> consultar() throws Exception {
    try {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Entradassalidas.findAll");
        return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
