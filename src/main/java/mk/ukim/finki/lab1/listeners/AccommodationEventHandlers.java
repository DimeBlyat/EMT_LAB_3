package mk.ukim.finki.lab1.listeners;

import mk.ukim.finki.lab1.events.AccommodationCreatedEvent;
import mk.ukim.finki.lab1.service.domain.AccommodationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccommodationEventHandlers {

    private final AccommodationService accommodationService;

    public AccommodationEventHandlers(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @EventListener
    public void onAccommodationCreated(AccommodationCreatedEvent event) {
        this.accommodationService.getAccommodationsPerHost();
    }
}

