package mk.ukim.finki.lab1.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Data
public class HostByCountry {

    @Id
    @Column(name = "country_id")
    private Long country_id;

    @Column(name = "num_host")
    private Integer numHosts;

    public Long getCountryId() {
        return country_id;
    }

    public Integer getNumHosts() {
        return numHosts;
    }
}
