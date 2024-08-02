package com.example.springexample.dao;

import com.example.springexample.modellentity.Postre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPostreDAO extends JpaRepository<Postre, Long> {
    public List<Postre> findByName(String name);
    public List<Postre> findByNameAndPrice(String name, Double price);
    public List<Postre> findByNameLike(String name);

    // PARA QUE SIRVE ESTA QUERY???
    @Query("select p from Postre p where p.name like %:nombre%")

    public List<Postre> findAllPostres(String nombre);
}
