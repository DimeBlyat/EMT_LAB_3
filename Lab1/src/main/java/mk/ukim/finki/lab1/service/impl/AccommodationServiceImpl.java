package mk.ukim.finki.lab1.service.impl;

import mk.ukim.finki.lab1.model.Accommodation;
import mk.ukim.finki.lab1.model.Host;
import mk.ukim.finki.lab1.model.dto.AccommodationDto;
import mk.ukim.finki.lab1.repository.AccommodationRepository;
import mk.ukim.finki.lab1.repository.HostRepository;
import mk.ukim.finki.lab1.service.AccommodationService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostRepository hostRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Accommodation> getAllAccommodations() {
        return this.accommodationRepository.findAll();
    }

    @Override
    public Accommodation create(AccommodationDto accommodationDto) throws Exception {
        Host host = this.hostRepository.findById(accommodationDto.getHostID()).orElseThrow(Exception::new);
        Accommodation accommodation = new Accommodation(accommodationDto.getName(), accommodationDto.getCategory(), host, accommodationDto.getNumRooms());

        return this.accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation update(Long ID, AccommodationDto accommodationDto) throws Exception {
        Accommodation accommodation = this.accommodationRepository.findById(ID).orElseThrow(Exception::new);
        Host host = this.hostRepository.findById(accommodationDto.getHostID()).orElseThrow(Exception::new);

        accommodation.setName(accommodationDto.getName());
        accommodation.setCategory(accommodationDto.getCategory());
        accommodation.setHost(host);
        accommodation.setNumRooms(accommodationDto.getNumRooms());

        return this.accommodationRepository.save(accommodation);
    }

    @Override
    public void deleteAccommodation(Long id) {
        this.accommodationRepository.deleteById(id);
    }

    @Override
    public Accommodation markAsRented(Long id) throws Exception {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(Exception::new);
        if (accommodation.isRented()) {
            return accommodation;
        }

        if (accommodation.getNumRooms() <= 0) {
            throw new Exception("No available rooms for booking ID: " + id);
        }

        if (accommodation.getNumRooms() - 1 == 0) {
            accommodation.setNumRooms(accommodation.getNumRooms() - 1);
            accommodation.setBooked(true);

            return this.accommodationRepository.save(accommodation);
        } else {
            accommodation.setNumRooms(accommodation.getNumRooms() - 1);

            return this.accommodationRepository.save(accommodation);
        }
    }
}
