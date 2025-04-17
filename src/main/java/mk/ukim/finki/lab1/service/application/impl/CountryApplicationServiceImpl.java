package mk.ukim.finki.lab1.service.application.impl;

import mk.ukim.finki.lab1.dto.CreateCountryDto;
import mk.ukim.finki.lab1.dto.DisplayCountryDto;
import mk.ukim.finki.lab1.service.application.CountryApplicationService;
import mk.ukim.finki.lab1.service.domain.CountryService;
import mk.ukim.finki.lab1.service.domain.HostService;
import mk.ukim.finki.lab1.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;
    private final HostService hostService;
    private final AccommodationService accommodationService;

    public CountryApplicationServiceImpl(CountryService countryService, HostService hostService, AccommodationService accommodationService) {
        this.countryService = countryService;
        this.hostService = hostService;
        this.accommodationService = accommodationService;
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return countryService.findAll().stream()
                .map(DisplayCountryDto::from).toList();
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService.findById(id)
                .map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> save(CreateCountryDto country) {
        return countryService.save(country.toCountry())
                .map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto country) throws Exception {
        return countryService.update(id, country.toCountry())
                .map(DisplayCountryDto::from);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        countryService.deleteById(id);
    }
}