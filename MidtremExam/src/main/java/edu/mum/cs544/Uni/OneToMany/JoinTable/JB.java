package edu.mum.cs544.Uni.OneToMany.JoinTable;

import javax.persistence.*;

@Entity
public class JB {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "B1", nullable = false,unique = true)
    private String b1;
}
