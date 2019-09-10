package edu.eci.arsw.blueprints.filtering;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import java.util.List;
import org.springframework.stereotype.Service;
/**
 *
 * @author 2128408
 */
@Service
public interface BlueprintsFiltering {
        public List<Point> filtrar(List<Point> p);
}
