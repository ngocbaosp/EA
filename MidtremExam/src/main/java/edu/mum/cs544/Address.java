package edu.mum.cs544;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userAdd;
}
