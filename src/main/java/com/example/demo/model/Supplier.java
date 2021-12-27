//package com.example.demo.model;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "supplier")
//public class Supplier {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "name")
//    private String name;
//    @OneToMany(mappedBy = "supplier")
//    private List<Product> product;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
