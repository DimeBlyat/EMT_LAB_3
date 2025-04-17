package mk.ukim.finki.lab1.service.application.impl;

import mk.ukim.finki.lab1.dto.CreateAccommodationDto;
import mk.ukim.finki.lab1.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1.model.domain.Host;
import mk.ukim.finki.lab1.service.application.AccommodationApplicationService;
import mk.ukim.finki.lab1.service.domain.AccommodationService;
import mk.ukim.finki.lab1.service.domain.CountryService;
import mk.ukim.finki.lab1.service.domain.HostService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {
    private final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService, CountryService countryService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return accommodationService.findAll().stream().map(DisplayAccommodationDto::from).toList();
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService.findById(id).map(DisplayAccommodationDto::from);
    }


    @Override
    public Optional<DisplayAccommodationDto> save(CreateAccommodationDto accommodationDto) {
        Optional<Host> host = hostService.findById(accommodationDto.host());

        if(host.isPresent()){
            return accommodationService.save(accommodationDto.toAccommodation(host.get()))
                    .map(DisplayAccommodationDto::from);
        }
        return Optional.empty();
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto accommodationDto) {

        Optional<Host> host = hostService.findById(accommodationDto.host());

        return accommodationService.update(id, accommodationDto.toAccommodation(host.orElse(null)))
                .map(DisplayAccommodationDto::from);

    }

    @Override
    public void deleteById(Long id) {
        accommodationService.deleteById(id);
    }

    @Override
    public Optional<DisplayAccommodationDto> isRented(Long id) {
        return accommodationService.findById(id).map(accommodationDto -> {
            accommodationDto.isRented();
            return accommodationService.save(accommodationDto).orElse(accommodationDto);
        }).map(DisplayAccommodationDto::from);
    }
}
