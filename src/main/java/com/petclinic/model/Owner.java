package com.petclinic.model;

import javax.persistence.*;

@Entity(name = "owners")

// Pet Owner Model defined.
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // id for AUTOINCREMENT.
    private int id;

    @Column(name="first_name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="address")
    private String address;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name="e_mail")
    private String e_mail;

    @Column(name="pets_id")
    private int pets_id;
}
