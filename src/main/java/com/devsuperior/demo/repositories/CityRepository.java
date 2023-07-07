package com.devsuperior.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.demo.entities.City;

public interface CityRepository extends JpaRepository<City,Long> {

}
