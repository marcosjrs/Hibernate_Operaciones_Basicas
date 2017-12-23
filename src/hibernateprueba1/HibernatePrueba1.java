package hibernateprueba1;

import dao.PersonaDao;
import java.util.List;
import javax.persistence.*;
import model.Persona;

public class HibernatePrueba1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        PersonaDao personaDao = new PersonaDao();
        List<Persona> personas = personaDao.listar();
        //imprimos los datos de persona, recordando que implementa toString()
        for(Persona p: personas){
            System.out.println("persona:" + p);
        }
    }

}
