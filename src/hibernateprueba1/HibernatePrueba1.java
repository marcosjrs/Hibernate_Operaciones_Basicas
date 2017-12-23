package hibernateprueba1;

import java.util.List;
import javax.persistence.*;
import model.Persona;

public class HibernatePrueba1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Comprobamos que todo funcione correctamente, haciendo una consulta
        //Recordamos que tenemos configurado con nombre HibernateEjemplo1 en el persistence.xml
        EntityManagerFactory factoria = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager em = factoria.createEntityManager();
        Query q = em.createQuery("SELECT p FROM Persona p");
        List<Persona> personas = q.getResultList();
        //imprimos los datos de persona, recordando que implementa toString()
        for(Persona p: personas){
            System.out.println("persona:" + p);
        }
    }

}
