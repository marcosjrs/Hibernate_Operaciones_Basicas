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
    

}
