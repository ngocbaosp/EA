package Exercise.B;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @ManyToOne
    @JoinTable(name = "book_publisher",joinColumns = {@JoinColumn(name = "bookId")}
    , inverseJoinColumns = {@JoinColumn(name = "publisherId")})
    private Publisher publisher;


    public Book(String title, Publisher publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
