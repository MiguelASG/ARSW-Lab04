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
public class SubsamplingFiltering implements BlueprintsFiltering{

    @Override
    public List<Point> filtrar(List<Point> p) {
        List<Point> rta = new ArrayList<Point>();
        for(int i=0; i<p.size(); i++){
            rta.add(p.get(i));
            i++;
        }
        return rta;
    }
    
}

