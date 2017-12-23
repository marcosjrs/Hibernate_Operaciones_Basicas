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
