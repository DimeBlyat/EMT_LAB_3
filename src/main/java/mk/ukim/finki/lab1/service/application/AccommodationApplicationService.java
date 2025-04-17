package mk.ukim.finki.lab1.service.application;

import mk.ukim.finki.lab1.dto.CreateAccommodationDto;
import mk.ukim.finki.lab1.dto.DisplayAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {

    List<DisplayAccommodationDto> findAll();

    Optional<DisplayAccommodationDto> findById(Long id);

    Optional<DisplayAccommodationDto> save(CreateAccommodationDto accommodationDto);

    Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto accommodationDto);

    void deleteById(Long id);

    Optional<DisplayAccommodationDto> isRented(Long id);
}
