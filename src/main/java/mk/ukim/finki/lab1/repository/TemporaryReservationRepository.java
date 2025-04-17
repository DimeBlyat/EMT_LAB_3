package mk.ukim.finki.lab1.repository;

import mk.ukim.finki.lab1.model.domain.Accommodation;
import mk.ukim.finki.lab1.model.domain.TemporaryReservation;
import mk.ukim.finki.lab1.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemporaryReservationRepository extends JpaRepository<TemporaryReservation, Long> {
    List<TemporaryReservation> findAllByUser(User user);
    void deleteAllByUser(User user);
    boolean existsByUserAndAccommodation(User user, Accommodation accommodation);
}