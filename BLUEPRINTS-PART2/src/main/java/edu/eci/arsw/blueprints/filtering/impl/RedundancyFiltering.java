/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.filtering.impl;

/**
 *
 * @author 2128408
 */
import edu.eci.arsw.blueprints.filtering.BlueprintsFiltering;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RedundancyFiltering implements BlueprintsFiltering{

    @Override
    public List<Point> filtrar(List<Point> p) {
        List<Point> rta = new ArrayList<Point>();
        boolean add = true;
        for(int i=0; i<p.size(); i++){
            for(int j=0; j<rta.size(); j++){
                if(p.get(i).getX()==rta.get(j).getX() && p.get(i).getY()==rta.get(j).getY()){
                    add = false;
                    break;
                }
            }
            if(add){
                rta.add(p.get(i));
            }
            else{
                add = true;
            }
        }
        return rta;
    }
    
}
