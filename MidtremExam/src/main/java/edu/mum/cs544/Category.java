package edu.mum.cs544;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id = null;

    private int version = 0;

    @Column(name = "CATEGORY_NAME")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Item> items;
}
