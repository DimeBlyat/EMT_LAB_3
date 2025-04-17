package mk.ukim.finki.lab1.service.domain.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.lab1.model.domain.Accommodation;
import mk.ukim.finki.lab1.model.domain.TemporaryReservation;
import mk.ukim.finki.lab1.model.domain.User;
import mk.ukim.finki.lab1.repository.AccommodationRepository;
import mk.ukim.finki.lab1.repository.TemporaryReservationRepository;
import mk.ukim.finki.lab1.repository.UserRepository;
import mk.ukim.finki.lab1.service.domain.TemporaryReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemporaryReservationServiceImpl implements TemporaryReservationService {

    private final TemporaryReservationRepository temporaryReservationRepository;
    private final UserRepository userRepository;
    private final AccommodationRepository accommodationRepository;

    public TemporaryReservationServiceImpl(TemporaryReservationRepository temporaryReservationRepository, UserRepository userRepository, AccommodationRepository accommodationRepository) {
        this.temporaryReservationRepository = temporaryReservationRepository;
        this.userRepository = userRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public Accommodation addToTemporaryList(String username, Long accommodationId) {
        User user = userRepository.findById(username).orElseThrow();
        Accommodation accommodation = accommodationRepository.findById(accommodationId).orElseThrow();

        if(accommodation.isRented()){
            throw new RuntimeException("Smestuvanjeto vekje e iznajmeno");
        }
        if(!temporaryReservationRepository.existsByUserAndAccommodation(user, accommodation)){
            TemporaryReservation reservation = new TemporaryReservation();
            reservation.setAccommodation(accommodation);
            reservation.setUser(user);
            temporaryReservationRepository.save(reservation);
        }
        System.out.println("Username: " + username);
        System.out.println("Smestuvanje ID: " + accommodationId);
        System.out.println("Already exists: " + temporaryReservationRepository.existsByUserAndAccommodation(user, accommodation));
        return accommodation;
    }

    @Override
    public List<Accommodation> getTemporaryReservations(String username) {
        User user = userRepository.findById(username).orElseThrow();
        List<TemporaryReservation> reservations = temporaryReservationRepository.findAllByUser(user);
        System.out.println("Getting temporary reservations for user: " + username);
        System.out.println("Found " + reservations.size() + " temporary reservations");
        return reservations.stream()
                .map(TemporaryReservation::getAccommodation)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Accommodation> confirmReservations(String username) {
        User user = userRepository.findById(username).orElseThrow();
        List<TemporaryReservation> reservations = temporaryReservationRepository.findAllByUser(user);

        List<Accommodation> confirmed = reservations.stream()
                .map(TemporaryReservation::getAccommodation)
                .map(s -> {
                    s.setBooked(true);
                    return accommodationRepository.save(s);
                })
                .toList();
        temporaryReservationRepository.deleteAllByUser(user);
        return confirmed;
    }
}