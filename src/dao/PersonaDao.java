package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Persona;

public class PersonaDao {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    public PersonaDao() {
        // cogemos la configuracion "HibernateEjemplo1" del persistence.xml
        emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void insertar(Persona persona) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();// Iniciamos una transaccion
            em.persist(persona);// Insertamos la nueva persona en el entityManager
            em.getTransaction().commit();// Hacemos efectivas las transacciones
        } catch (Exception ex) {
            System.out.println("Error al insetar objeto:" + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void actualizar(Persona personaActualizada) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(personaActualizada); // actualizamos los datos con personaActualizada
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error al actualizar objeto:" + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }  
    
    public void eliminar(Persona personaAEliminar){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            //para eliminar necesitamos "recuperarla" y para estos casos se utiliza el merge
            em.remove(em.merge(personaAEliminar)); 
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error al actualizar objeto:" + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persona> listar() {
        em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Persona p"); //creamos con hql
        return query.getResultList();
    }

    public Persona buscarPorId(Persona personaBuscarConId) {
        em = getEntityManager();
        return em.find(Persona.class, personaBuscarConId.getIdPersona());
    }

}
