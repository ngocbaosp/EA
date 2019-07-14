package edu.mum.cs544.Uni.OneToMany.JoinTable;


import javax.persistence.*;
import java.util.List;

@Entity
public class JA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDA")
    private int idA;
    private String a1;

    @OneToMany
    @JoinTable(name = "JAJB",
            joinColumns={@JoinColumn(name = "abc_idid")},
            inverseJoinColumns = {@JoinColumn(name = "xyz_idid")})


    private List<JB> jbs;
}
