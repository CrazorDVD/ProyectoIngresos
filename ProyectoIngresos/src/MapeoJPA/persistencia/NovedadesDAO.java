/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA.persistencia;

import MapeoJPA.Novedades;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Andres Daraviña
 */
public class NovedadesDAO implements INovedadesDAO{

    @Override
    public void insertar(Novedades novedades) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(novedades);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Novedades novedades) throws Exception {
    try {
            EntityManagerHelper.getEntityManager().merge(novedades);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Novedades novedades) throws Exception {
    try {
            EntityManagerHelper.getEntityManager().remove(novedades);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Novedades consultarporid(Integer iDNovedad) throws Exception {
    try {
           return EntityManagerHelper.getEntityManager().find(Novedades.class, iDNovedad);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Novedades> consultar() throws Exception {
    try {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Novedades.findAll");
        return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
