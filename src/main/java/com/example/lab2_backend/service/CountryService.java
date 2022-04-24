package com.example.lab2_backend.service;

import com.example.lab2_backend.model.Author;
import com.example.lab2_backend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CountryService{
    List<Country> findAll();
    Country create(String name, String continent);
}
