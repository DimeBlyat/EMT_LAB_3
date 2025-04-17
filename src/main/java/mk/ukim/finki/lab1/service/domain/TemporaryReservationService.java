package mk.ukim.finki.lab1.service.domain;

import mk.ukim.finki.lab1.model.domain.Accommodation;

import java.util.List;

public interface TemporaryReservationService {

    Accommodation addToTemporaryList(String username, Long accommodationId);
    List<Accommodation> getTemporaryReservations(String username);
    List<Accommodation> confirmReservations(String username);

}