package mk.ukim.finki.lab1.repository;

import mk.ukim.finki.lab1.model.views.AccommodationPerHost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccommodationsPerHostRepository extends JpaRepository<AccommodationPerHost, Long> {
    @Query(value = "SELECT * FROM accommodations_per_host", nativeQuery = true)
    List<AccommodationPerHost> findAllFromView();
}
