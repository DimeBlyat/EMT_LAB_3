package mk.ukim.finki.lab1.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    private Country country;

    public Host(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
