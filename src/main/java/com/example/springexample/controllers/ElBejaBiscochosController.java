package com.example.springexample.controllers;

import com.example.springexample.modellentity.Postre;
import com.example.springexample.services.IPostreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController()
@RequestMapping("/api")
public class ElBejaBiscochosController {
    @Autowired
    private IPostreService postreService;

    @GetMapping("/elbejabiscochos")
    public List<Postre> getElBejaBiscochos() {
        System.out.println("getElBejaBiscochos");

        return postreService.findAll();
    }

    @PostMapping("/elbejabiscochos")
    public ResponseEntity<?> postElBejaBiscochos (@Valid @RequestBody Postre postre) {
        System.out.println("postElBejaBiscochos");

        Map<String,String> response= new HashMap<>();

        try{
            postreService.save(postre);
        } catch (Exception e){
            response.put("message",e.getMessage());
            return ResponseEntity.status(500).body(response);
        }

        return ResponseEntity.status(201).body(postre);
    }

    @DeleteMapping("/elbejabiscochos/{id}")
    public void deleteElBejaBiscochos (@PathVariable Long id) {
        System.out.println("deleteElBejaBiscochos");

        postreService.deleteById(id);
    }

    @GetMapping("/elbejabiscochos/{id}")
    public ResponseEntity<?> getElBejaBiscochosById (@PathVariable Long id) {
        System.out.println("getElBejaBiscochosById");

        Postre p = postreService.findById(id);
        System.out.println(p);

        Map<String,String> response= new HashMap<>();

        if( p==null ) {
            response.put("message","dessert not found");
            return ResponseEntity.status(404).body(response);
        }

        return ResponseEntity.status(200).body(p);
    }

    @PutMapping("/elbejabiscochos/{id}")
    public Postre putElBejaBiscochos (@RequestBody Postre postre, @PathVariable Long id) {
        System.out.println("putElBejaBiscochos");

        Postre p = postreService.findById(id);

        if( p==null ) {
            throw new RuntimeException("Postre no encontrado");
        }

        p.setName(postre.getName());
        p.setDescription(postre.getDescription());
        p.setPrice(postre.getPrice());

        return postreService.save(p);
    }
}
