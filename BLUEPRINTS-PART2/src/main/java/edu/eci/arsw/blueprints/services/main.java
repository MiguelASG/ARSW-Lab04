/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.services;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author GULUMA
 */
public class main {
    
    
    public static void main(String[] args) throws BlueprintPersistenceException, BlueprintNotFoundException{
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);
        
        Blueprint ej = new Blueprint("prueba", "primera");
        Blueprint ej1 = new Blueprint("prueba", "segunda");
        Blueprint ej2 = new Blueprint("otraprueba", "primera");
        bps.addNewBlueprint(ej);
        bps.addNewBlueprint(ej1);
        bps.addNewBlueprint(ej2);
        
        Set<Blueprint> bp = bps.getAllBlueprints();
        System.out.println("Los blueprints que han sido guardados son:");
        for(Blueprint b: bp){
                System.out.println(b.toString());
        }
        System.out.println();
        Blueprint bp1 = bps.getBlueprint("prueba", "primera");
        System.out.println("El blueprint para la prueba primera es:");
        System.out.println(bp1.toString());
        System.out.println();
        System.out.println("Los blueprint para la prueba son:");
        bp = bps.getBlueprintsByAuthor("prueba");
        for(Blueprint b: bp){
                System.out.println(b.toString());
        }
        
        
    }
    
    
}
