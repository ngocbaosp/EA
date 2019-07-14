package edu.mum.cs544.Uni.OneToMany.Default;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "BBB")
public class B {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String b1;

}
