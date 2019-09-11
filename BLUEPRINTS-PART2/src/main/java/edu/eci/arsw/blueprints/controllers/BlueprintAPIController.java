/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.controllers;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(value = "/blueprints")
@Service
public class BlueprintAPIController {
    @Autowired
    private BlueprintsServices bps;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetRecursosBlue(){
        Set<Blueprint> bp;
        try {
            bp = bps.getAllBlueprints();
            return new ResponseEntity<>(bp, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 500",HttpStatus.INTERNAL_SERVER_ERROR);
        }            
    
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "{author}")
    public ResponseEntity<?> GetRecursosBlueAuthor(@PathVariable("author") String author){
        Set<Blueprint> bp;
        try {
            bp = bps.getBlueprintsByAuthor(author);
            return new ResponseEntity<>(bp, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }            
    
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "{author}/{bpname}")
    public ResponseEntity<?> GetRecursoBlueAuthor(@PathVariable("author") String author, @PathVariable("bpname") String bpname){
        Blueprint bp;
        try {
            bp = bps.getBlueprint(author, bpname);
            return new ResponseEntity<>(bp, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }            
    
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> newBlue(@RequestBody Blueprint bp){
        try {
            bps.addNewBlueprint(bp);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 403",HttpStatus.FORBIDDEN);
        }            
    
    }
    
    @RequestMapping(method = RequestMethod.PUT, path = "{author}/{bpname}")
    public ResponseEntity<?> putBlue(@RequestBody Blueprint bp, @PathVariable("author") String author, @PathVariable("bpname") String bpname){
        try {
            bps.update(bp, author, bpname);
            return new ResponseEntity<>(bp, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 403",HttpStatus.FORBIDDEN);
        }            
    
    }
    
    
    
}

