package com.petclinic.repository;

import com.petclinic.model.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetsRepository extends JpaRepository<Pets,Integer>{

    @Query(value="SELECT * FROM Pets p WHERE p.name like %:keyword%",nativeQuery = true)
    List<Pets> findByKeyword(@Param("keyword") String keyword);
}

////  or p.owner.name like %:keyword%