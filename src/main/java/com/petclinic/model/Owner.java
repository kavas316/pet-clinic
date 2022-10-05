package com.petclinic.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owners")
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

    @OneToMany(targetEntity = Pets.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id",referencedColumnName = "id")
    private List<Pets> pets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

}
