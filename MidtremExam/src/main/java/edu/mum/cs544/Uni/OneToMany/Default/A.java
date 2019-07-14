package edu.mum.cs544.Uni.OneToMany.Default;

import javax.persistence.*;
import java.util.List;

@Entity(name = "AAA")
@Table(name = "TA")
public class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDA")
    private int idA;
    private String a1;

    @OneToMany
    private List<B> bs;

}
