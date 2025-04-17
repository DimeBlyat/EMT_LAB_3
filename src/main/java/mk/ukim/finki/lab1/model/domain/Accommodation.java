package mk.ukim.finki.lab1.model.domain;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.lab1.model.enumerations.Category;

@Entity
@Data
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

    public Accommodation() {}
    public Accommodation(String name, Category category, Host host, Integer numRooms) {
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

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setBooked(boolean isRented) {
        this.isRented = isRented;
    }
}
