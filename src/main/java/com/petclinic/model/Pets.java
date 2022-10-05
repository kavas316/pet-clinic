package com.petclinic.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pet_ name")
    private String pet_name;

    @Column(name = "pet_species")
    private String pet_species;

    @Column(name = "pet_genus")
    private String pet_genus;

    @Column(name = "pet_old")
    private int pet_old;

    @Column(name = "pet_desc")
    private String pet_desc;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    public String getPet_species() {
        return pet_species;
    }

    public void setPet_species(String pet_species) {
        this.pet_species = pet_species;
    }

    public String getPet_genus() {
        return pet_genus;
    }

    public void setPet_genus(String pet_genus) {
        this.pet_genus = pet_genus;
    }

    public int getPet_old() {
        return pet_old;
    }

    public void setPet_old(int pet_old) {
        this.pet_old = pet_old;
    }

    public String getPet_desc() {
        return pet_desc;
    }

    public void setPet_desc(String pet_desc) {
        this.pet_desc = pet_desc;
    }
}
