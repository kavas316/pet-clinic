package com.petclinic.repository;

import com.petclinic.model.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepository extends JpaRepository<Pets,Integer>{
}
