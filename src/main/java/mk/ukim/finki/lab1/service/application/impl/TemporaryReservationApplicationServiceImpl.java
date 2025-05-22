package mk.ukim.finki.lab1.service.application.impl;

import mk.ukim.finki.lab1.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1.model.domain.Accommodation;
import mk.ukim.finki.lab1.service.application.TemporaryReservationApplicationService;
import mk.ukim.finki.lab1.service.domain.TemporaryReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporaryReservationApplicationServiceImpl implements TemporaryReservationApplicationService {

    private final TemporaryReservationService temporaryReservationService;

    public TemporaryReservationApplicationServiceImpl(TemporaryReservationService temporaryReservationService) {
        this.temporaryReservationService = temporaryReservationService;
    }


    @Override
    public DisplayAccommodationDto addToTemporaryList(String username, Long accommodationId) {
        Accommodation s = temporaryReservationService.addToTemporaryList(username, accommodationId);
        return DisplayAccommodationDto.from(s);
    }

    @Override
    public List<DisplayAccommodationDto> getTemporaryReservations(String username) {
        List<Accommodation> accommodations = temporaryReservationService.getTemporaryReservations(username);
        return accommodations.stream().map(DisplayAccommodationDto::from).toList();
    }

    @Override
    public List<DisplayAccommodationDto> confirmReservations(String username) {
        List<Accommodation> confirmed = temporaryReservationService.confirmReservations(username);
        return confirmed.stream().map(DisplayAccommodationDto::from).toList();
    }
}