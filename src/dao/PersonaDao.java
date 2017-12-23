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
