package mk.ukim.finki.lab1.repository;

import jakarta.transaction.Transactional;
import mk.ukim.finki.lab1.model.views.HostByCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HostsByCountryRepository extends JpaRepository<HostByCountry, Long> {
    @Modifying
    @Transactional
    @Query(value = "REFRESH MATERIALIZED VIEW host_by_country", nativeQuery = true)
    void refreshView();
}
