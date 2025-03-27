package mk.ukim.finki.lab1.repository;

import mk.ukim.finki.lab1.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
