package edu.mum.cs544;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id = null;

    private int version = 0;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    private String email;

    @Column(name = "`RANK`")

    private int ranking = 0;

    @Column(name = "IS_ADMIN")

    private boolean admin = false;

    @OneToMany(mappedBy = "user")
    List<Comment> comments;

    @OneToMany(mappedBy = "userAdd")
    List<Address> addresses;
}
