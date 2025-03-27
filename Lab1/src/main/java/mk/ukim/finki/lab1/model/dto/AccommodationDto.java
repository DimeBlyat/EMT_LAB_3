package mk.ukim.finki.lab1.model.dto;

import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.lab1.model.Accommodation;
import mk.ukim.finki.lab1.model.Category;

//public record DisplayAccommodationDto(
//        String name,
//        Integer numRooms,
//        Category category,
//        Host host) {
//
//    public static DisplayAccommodationDto from(Accommodation accommodation) {
//        return new DisplayAccommodationDto(
//                accommodation.getName(),
//                accommodation.getNumRooms(),
//                accommodation.getCategory(),
//                accommodation.getHost()
//        );
//    }
//
//    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations) {
//        return accommodations.stream().map(DisplayAccommodationDto::from).collect(Collectors.toList());
//    }
//
//    public Accommodation toAccommodation(Category category, Host host) {
//        return new Accommodation(name, numRooms, category, host);
//    }
//}

@Setter
@Getter
public class AccommodationDto {

    private String name;

    private Category category;

    private Long hostID;

    private int numRooms;

    public AccommodationDto(String name, Category category, Long hostID, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.hostID = hostID;
        this.numRooms = numRooms;
    }

}
