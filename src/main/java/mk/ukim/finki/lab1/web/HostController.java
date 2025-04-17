package mk.ukim.finki.lab1.web;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.ukim.finki.lab1.dto.DisplayHostDto;
import mk.ukim.finki.lab1.model.domain.Host;
import mk.ukim.finki.lab1.dto.CreateHostDto;
import mk.ukim.finki.lab1.service.application.HostApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@Tag(name = "Host API", description = "Managing hosts")
public class HostController {

    private final HostApplicationService hostService;

    public HostController(HostApplicationService hostService) {
        this.hostService = hostService;
    }

    @Operation(summary = "Get all hosts", description = "Find all hosts")
    @GetMapping
    public List<DisplayHostDto> findAll() {
        return hostService.findAll();
    }

    @Operation(summary = "Get host by id", description = "Find host by id")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayHostDto> findById(@PathVariable Long id) {
        return hostService.findById(id).map(i -> ResponseEntity.ok().body(i))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Save host", description = "save host")
    @PostMapping("/add")
    public ResponseEntity<DisplayHostDto> save(@RequestBody CreateHostDto host) {
        return hostService.save(host)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Edit host", description = "Edit host")
    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayHostDto> update(@PathVariable Long id, @RequestBody CreateHostDto host){
        return hostService.update(id, host).map(i -> ResponseEntity.ok().body(i))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete host", description = "Delete host")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Host> deleteById(@PathVariable Long id){
        if(hostService.findById(id).isPresent()){
            hostService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }

}