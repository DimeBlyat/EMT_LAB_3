package mk.ukim.finki.lab1.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.ukim.finki.lab1.model.domain.Country;
import mk.ukim.finki.lab1.service.domain.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@Tag(name="Country API", description = "Managing countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Operation(summary = "Get all countries", description = "Listaj gi site zemji")
    @GetMapping
    public List<Country> findAll(){
        return countryService.findAll();
    }

    @Operation(summary = "Find country by id", description = "Najdi zemja spored id")
    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        return countryService.findById(id)
                .map(i -> ResponseEntity.ok().body(i))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Save country", description = "Zacuvaj zemja")
    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestBody Country country){
        return countryService.save(country)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Edit country", description = "Editiraj zemja")
    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id, @RequestBody Country country) throws Exception {
        return countryService.update(id, country)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete country", description = "Izbrisi zemja")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> deleteById(@PathVariable Long id) throws Exception {
        if(countryService.findById(id).isPresent()){
            countryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }


}