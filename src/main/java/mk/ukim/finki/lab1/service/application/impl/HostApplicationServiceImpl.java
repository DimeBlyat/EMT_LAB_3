package mk.ukim.finki.lab1.service.application.impl;

import mk.ukim.finki.lab1.dto.CreateHostDto;
import mk.ukim.finki.lab1.dto.DisplayHostDto;
import mk.ukim.finki.lab1.model.domain.Country;
import mk.ukim.finki.lab1.service.application.HostApplicationService;
import mk.ukim.finki.lab1.service.domain.CountryService;
import mk.ukim.finki.lab1.service.domain.HostService;
import mk.ukim.finki.lab1.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {

    private final CountryService countryService;
    private final HostService hostService;

    public HostApplicationServiceImpl(CountryService countryService, HostService hostService, AccommodationService accommodationService) {
        this.countryService = countryService;
        this.hostService = hostService;
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return hostService.findAll().stream().map(DisplayHostDto::from).toList();
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto host) {
        Optional<Country> country = countryService.findById(host.Country());

        if(country.isPresent()){
            return hostService.save(host.toHost(country.get()))
                    .map(DisplayHostDto::from);
        }
        return Optional.empty();
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto host) {
        Optional<Country> country = countryService.findById(host.Country());

        return hostService.update(id, host.toHost(country.orElse(null)))
                .map(DisplayHostDto::from);
    }

    @Override
    public void deleteById(Long id) {
        hostService.deleteById(id);
    }
}