package mk.ukim.finki.lab1.web;

import mk.ukim.finki.lab1.model.Accommodation;
import mk.ukim.finki.lab1.model.dto.AccommodationDto;
import mk.ukim.finki.lab1.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public List<Accommodation> getAllAccommodations() {
        return accommodationService.getAllAccommodations();
    }

    @PostMapping("/add-accommodation/{id}")
    public ResponseEntity<Accommodation> addAccommodation(@RequestBody AccommodationDto accommodationDto) throws Exception {
        return ResponseEntity.ok(this.accommodationService.create(accommodationDto));
    }

    @PutMapping("/edit-accommodation/{id}")
    public ResponseEntity<Accommodation> editAccommodation(@PathVariable Long id, @RequestBody AccommodationDto accommodationDto) throws Exception {
        return ResponseEntity.ok(this.accommodationService.update(id, accommodationDto));
    }

    @DeleteMapping("delete-accommodation/{id}")
    public  ResponseEntity<Void> deleteAccommodation(@PathVariable Long id) {
        this.accommodationService.deleteAccommodation(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("rent/{id}")
    public ResponseEntity<Accommodation> markAsRented(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(this.accommodationService.markAsRented(id));
    }
}
