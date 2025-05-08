package mk.ukim.finki.lab1.repository;

import mk.ukim.finki.lab1.model.views.HostByCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostsByCountryRepository extends JpaRepository<HostByCountry, String> {
}
