/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA.persistencia;

import MapeoJPA.Novedades;
import MapeoJPA.Usuarios;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Andres Daraviña
 */
public class UsuariosDAO implements IUsuariosDAO{

    @Override
    public void insertar(Usuarios usuarios) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(usuarios);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Usuarios usuarios) throws Exception {
    try {
            EntityManagerHelper.getEntityManager().merge(usuarios);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Usuarios usuarios) throws Exception {
    try {
            EntityManagerHelper.getEntityManager().remove(usuarios);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Usuarios consultarporid(Integer cedulaUsuarios) throws Exception {
    try {
           return EntityManagerHelper.getEntityManager().find(Usuarios.class, cedulaUsuarios);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Usuarios> consultar() throws Exception {
    try {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Usuarios.findAll");
        return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
