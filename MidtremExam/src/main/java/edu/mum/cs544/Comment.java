package edu.mum.cs544;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id = null;

    @ManyToOne
    @JoinColumn(name = "user_USER_ID")
    private User user;

    @ManyToOne
    @JoinTable(name = "comment_item", joinColumns = {@JoinColumn(name = "comment")}
            , inverseJoinColumns = @JoinColumn(name = "item"))
    private Item item;

    private String content;
}
