package mk.ukim.finki.lab1.service.application;

import mk.ukim.finki.lab1.dto.CreateAccommodationDto;
import mk.ukim.finki.lab1.dto.CreateCountryDto;
import mk.ukim.finki.lab1.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {

    List<DisplayCountryDto> findAll();

    Optional<DisplayCountryDto> findById(Long id);

    Optional<DisplayCountryDto> save(CreateCountryDto country);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto country) throws Exception;

    void deleteById(Long id) throws Exception;

}
