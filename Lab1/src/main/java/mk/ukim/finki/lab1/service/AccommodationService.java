package mk.ukim.finki.lab1.service;

import mk.ukim.finki.lab1.model.Accommodation;
import mk.ukim.finki.lab1.model.dto.AccommodationDto;

import java.util.List;

public interface AccommodationService {

    List<Accommodation> getAllAccommodations();

    Accommodation create(AccommodationDto accommodationDto) throws Exception;

    Accommodation update(Long ID, AccommodationDto accommodationDto) throws Exception;

    void deleteAccommodation(Long id);

    Accommodation markAsRented(Long id) throws Exception;
}
