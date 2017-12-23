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
        
        //Creamos una instancia de Persona y la insertamos
        Persona Miriam = new Persona();
        Miriam.setNombre("Miriam");
        Miriam.setApellido("VB");
        personaDao.insertar(Miriam);   
        
        //Listamos todas las personas, recordando que implementa toString()
        List<Persona> personas = personaDao.listar();
        for(Persona p: personas){
            System.out.println("persona:" + p);
        }
        
        //Buscamos por un id
        Persona personaABuscar = new Persona();
        personaABuscar.setIdPersona(personas.get(0).getIdPersona());
        Persona personaEncontrada = personaDao.buscarPorId(personaABuscar );
        System.out.println("persona encontrada:" + personaEncontrada);
    }

}
