package com.example.springexample.services;

import com.example.springexample.modellentity.Postre;

import java.util.*;

public interface IPostreService {
    public List<Postre> findAll();

    public Postre save(Postre postre);

    public Postre findById(long id);

    public void deleteById(Long id);
}
