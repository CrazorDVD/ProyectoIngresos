/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA.persistencia;

import MapeoJPA.Personal;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Andres Daraviña
 */
public class PersonalDAO implements IPersonalDAO{

    @Override
    public void insertar(Personal personal) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(personal);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Personal novedades) throws Exception {
    try {
            EntityManagerHelper.getEntityManager().merge(novedades);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Personal novedades) throws Exception {
    try {
            EntityManagerHelper.getEntityManager().remove(novedades);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Personal consultarporid(Integer cedulaPersonal) throws Exception {
    try {
           return EntityManagerHelper.getEntityManager().find(Personal.class, cedulaPersonal);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Personal> consultar() throws Exception {
    try {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Personal.findAll");
        return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
