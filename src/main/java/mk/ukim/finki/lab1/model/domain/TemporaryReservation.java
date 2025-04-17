package mk.ukim.finki.lab1.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TemporaryReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Accommodation accommodation;

    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public Accommodation getAccommodation() {
        return accommodation;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}