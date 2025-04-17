package mk.ukim.finki.lab1.dto;

import mk.ukim.finki.lab1.model.domain.Accommodation;
import mk.ukim.finki.lab1.model.enumerations.Category;
import mk.ukim.finki.lab1.model.domain.Host;

import java.util.List;
import java.util.stream.Collectors;

public record CreateAccommodationDto(
        String name,
        Integer numRooms,
        Category category,
        Long host) {

    public static CreateAccommodationDto from(Accommodation accommodation) {
        return new CreateAccommodationDto(
                accommodation.getName(),
                accommodation.getNumRooms(),
                accommodation.getCategory(),
                accommodation.getHost().getId()
        );
    }

    public static List<CreateAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations.stream().map(CreateAccommodationDto::from).collect(Collectors.toList());
    }

    public Accommodation toAccommodation(Host host) {
        return new Accommodation(name, category, host, numRooms);
    }
}