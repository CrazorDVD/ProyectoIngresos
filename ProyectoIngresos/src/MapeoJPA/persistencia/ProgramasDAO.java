/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA.persistencia;

import MapeoJPA.Programas;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Andres Daraviña
 */
public class ProgramasDAO implements IProgramasDAO{

    @Override
    public void insertar(Programas programas) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(programas);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Programas novedades) throws Exception {
    try {
            EntityManagerHelper.getEntityManager().merge(novedades);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Programas novedades) throws Exception {
    try {
            EntityManagerHelper.getEntityManager().remove(novedades);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Programas consultarporid(Integer iDPrograma) throws Exception {
    try {
           return EntityManagerHelper.getEntityManager().find(Programas.class, iDPrograma);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Programas> consultar() throws Exception {
    try {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Programas.findAll");
        return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
