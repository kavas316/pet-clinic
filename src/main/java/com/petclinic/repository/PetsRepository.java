package com.petclinic.repository;

import com.petclinic.model.Pets;
import com.petclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetsRepository extends JpaRepository<Pets,Integer>{

    //@Query(value="SELECT * FROM Pets p WHERE p.name OR p.owner.name like %:keyword%",nativeQuery = true)
    @Query(value="SELECT * FROM Pets p INNER JOIN Owners ON p.owner_id = Owners.id WHERE Owners.name  like %:keyword% OR p.name like %:keyword% OR Owners.surname like %:keyword%",nativeQuery = true)
    List<Pets> findByKeyword(@Param("keyword") String keyword);
}

////  or p.owner.name like %:keyword%