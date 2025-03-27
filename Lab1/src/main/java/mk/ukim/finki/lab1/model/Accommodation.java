package mk.ukim.finki.lab1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private Category category;

    @Setter
    @Getter
    @ManyToOne
    private Host host;

    private Integer numRooms;

    private boolean isRented;

    public Accommodation(String name, Category category, Host host, int numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.isRented = false;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setBooked(boolean isRented) {
        this.isRented = isRented;
    }
}
