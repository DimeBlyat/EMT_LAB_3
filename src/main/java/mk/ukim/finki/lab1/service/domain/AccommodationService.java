package mk.ukim.finki.lab1.service.domain;

import mk.ukim.finki.lab1.model.domain.Accommodation;
import mk.ukim.finki.lab1.dto.CreateAccommodationDto;
import mk.ukim.finki.lab1.model.views.AccommodationPerHost;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Optional;

@EnableScheduling
public interface AccommodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> findById(Long id);

    Optional<Accommodation> save(Accommodation accommodation);

    Optional<Accommodation> update(Long id, Accommodation accommodation);

    Optional<Accommodation> isRented(Long id);

    void deleteById(Long id);

    List<AccommodationPerHost> getAccommodationsPerHost();
}
