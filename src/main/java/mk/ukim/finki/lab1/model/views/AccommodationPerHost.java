package mk.ukim.finki.lab1.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
public class AccommodationPerHost {

    @Id
    @Column(name = "host_id")
    private Long host_id;

    @Column(name = "accommodation_count")
    private Integer numAccommodations;
}
