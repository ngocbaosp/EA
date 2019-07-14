package edu.mum.cs544;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id = null;

    @Column(name = "ITEM_NAME")
    private String name;

    @Column(name = "DESCRIPTION", length = 4000)
    private String description;

    private BigDecimal reservePrice;

    @ManyToMany
    @JoinTable(name = "category_items", joinColumns = {@JoinColumn(name = "Item_ID")}
            , inverseJoinColumns = {@JoinColumn(name = "Category_ID")})
    private Set<Category> categories;

    @OneToMany(mappedBy = "item")
    List<Comment> comments;
}
