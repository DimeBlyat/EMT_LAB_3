package mk.ukim.finki.lab1.dto;

import mk.ukim.finki.lab1.model.domain.Accommodation;
import mk.ukim.finki.lab1.model.enumerations.Category;
import mk.ukim.finki.lab1.model.domain.Host;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAccommodationDto(
        Long id,
        String name,
        Integer numRooms,
        Category category,
        Host host,
        Boolean isRented) {

    public static DisplayAccommodationDto from(Accommodation accommodation) {
        return new DisplayAccommodationDto(
                accommodation.getID(),
                accommodation.getName(),
                accommodation.getNumRooms(),
                accommodation.getCategory(),
                accommodation.getHost(),
                accommodation.isRented()
        );
    }

    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations.stream().map(DisplayAccommodationDto::from).collect(Collectors.toList());
    }

    public Accommodation toAccommodation(Category category, Host host) {
        return new Accommodation(name, category, host, numRooms);
    }
}

//@Setter
//@Getter
//public class AccommodationDto {
//
//    private String name;
//
//    private Category category;
//
//    private Long hostID;
//
//    private int numRooms;
//
//    public AccommodationDto(String name, Category category, Long hostID, Integer numRooms) {
//        this.name = name;
//        this.category = category;
//        this.hostID = hostID;
//        this.numRooms = numRooms;
//    }
//
//}
