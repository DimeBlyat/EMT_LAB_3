package mk.ukim.finki.lab1.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.ukim.finki.lab1.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1.dto.CreateAccommodationDto;
import mk.ukim.finki.lab1.model.views.AccommodationPerHost;
import mk.ukim.finki.lab1.service.application.AccommodationApplicationService;
import mk.ukim.finki.lab1.service.domain.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
@Tag(name = "Accommodation API", description = "Managing accommodations")
public class AccommodationController {

    private final AccommodationApplicationService accommodationService;
    private final AccommodationService service;

    public AccommodationController(AccommodationApplicationService accommodationService, AccommodationService service) {
        this.accommodationService = accommodationService;
        this.service = service;
    }

    @GetMapping("/by-host")
    public List<AccommodationPerHost> getByHost() {
        return service.getAccommodationsPerHost();
    }

    @PostMapping("/refresh-view")
    public ResponseEntity<List<AccommodationPerHost>> refreshView() {
        service.getAccommodationsPerHost();
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get all accommodations", description = "It returns a list of all accommodations")
    @GetMapping
    public List<DisplayAccommodationDto> findAll(){
        return accommodationService.findAll();
    }

    @Operation(summary = "Get accommodation by id", description = "Find all accommodations by ID")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayAccommodationDto> findById(@PathVariable Long id){
        return accommodationService.findById(id)
                .map(i -> ResponseEntity.ok().body(i))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Save accommodation", description = "Save accommodation")
    @PostMapping("/add")
    public ResponseEntity<DisplayAccommodationDto> save(@RequestBody CreateAccommodationDto createAccommodationDto){
        return accommodationService.save(createAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Edit an accommodation", description = "Edit accommodation")
    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayAccommodationDto> update(@PathVariable Long id, @RequestBody CreateAccommodationDto createAccommodationDto){
        return accommodationService.update(id, createAccommodationDto)
                .map(i -> ResponseEntity.ok().body(i))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete accommodation", description = "Delete accommodation")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayAccommodationDto> delete(@PathVariable Long id){
        if(accommodationService.findById(id).isPresent()){
            accommodationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Rent accommodation", description = "Rent accommodation")
    @PutMapping("/isRented/{id}")
    public ResponseEntity<DisplayAccommodationDto> isRented(@PathVariable Long id) {
        return accommodationService.isRented(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}