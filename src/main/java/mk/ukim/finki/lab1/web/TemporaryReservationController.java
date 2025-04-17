package mk.ukim.finki.lab1.web;

import io.swagger.v3.oas.annotations.Operation;
import mk.ukim.finki.lab1.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1.model.domain.User;
import mk.ukim.finki.lab1.service.application.TemporaryReservationApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temp-reservations")
public class TemporaryReservationController {

    private final TemporaryReservationApplicationService temporaryReservationApplicationService;

    public TemporaryReservationController(TemporaryReservationApplicationService temporaryReservationApplicationService) {
        this.temporaryReservationApplicationService = temporaryReservationApplicationService;
    }

    @Operation(summary = "Add temporary reservation", description = "add accommodation by id")
    @PostMapping("/add/{id}")
    public ResponseEntity<DisplayAccommodationDto> add(@PathVariable Long id, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        DisplayAccommodationDto dto = temporaryReservationApplicationService.addToTemporaryList(user.getUsername(), id);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Get all temporary reservations", description = "List all accommodation")
    @GetMapping
    public List<DisplayAccommodationDto> list(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return temporaryReservationApplicationService.getTemporaryReservations(user.getUsername());
    }

    @Operation(summary = "Confirm reservations", description = "Confirm all reservations")
    @PostMapping("/confirm")
    public ResponseEntity<List<DisplayAccommodationDto>> confirm(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        List<DisplayAccommodationDto> confirmed = temporaryReservationApplicationService.confirmReservations(user.getUsername());
        return ResponseEntity.ok(confirmed);
    }

}