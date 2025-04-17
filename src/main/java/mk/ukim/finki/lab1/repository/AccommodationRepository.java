package mk.ukim.finki.lab1.repository;

import mk.ukim.finki.lab1.model.domain.Accommodation;
import mk.ukim.finki.lab1.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{
    Optional<Country> findByName(String country);
}
