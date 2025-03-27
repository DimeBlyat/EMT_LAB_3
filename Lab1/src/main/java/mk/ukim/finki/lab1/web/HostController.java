package mk.ukim.finki.lab1.web;

import mk.ukim.finki.lab1.model.Host;
import mk.ukim.finki.lab1.model.dto.AccommodationDto;
import mk.ukim.finki.lab1.service.HostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @GetMapping
    public List<Host> findAllHosts() {
        return this.hostService.findAllHosts();
    }

}