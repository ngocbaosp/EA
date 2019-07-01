package Exercise.B;

import javax.persistence.Entity;

@Entity
public class DVD extends Product {
    private String genre;

    public DVD(String name, String description, String genre) {
        super(name, description);
        this.genre = genre;
    }
}
