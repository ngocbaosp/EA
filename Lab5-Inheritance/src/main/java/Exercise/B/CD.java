package Exercise.B;

import javax.persistence.Entity;

@Entity
public class CD extends Product {

    private String artist;

    public CD(String artist) {
        this.artist = artist;
    }

    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }
}
