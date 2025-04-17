package mk.ukim.finki.lab1.service.application;

import mk.ukim.finki.lab1.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1.model.domain.Accommodation;

import java.util.List;

public interface TemporaryReservationApplicationService {
    DisplayAccommodationDto addToTemporaryList(String username, Long accommodationId);
    List<DisplayAccommodationDto> getTemporaryReservations(String username);
    List<DisplayAccommodationDto> confirmReservations(String username);
}