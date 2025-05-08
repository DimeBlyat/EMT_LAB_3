package mk.ukim.finki.lab1.events;

import lombok.Getter;
import mk.ukim.finki.lab1.model.domain.Accommodation;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class AccommodationCreatedEvent extends ApplicationEvent {

    public AccommodationCreatedEvent(Accommodation source) {
        super(source);
    }
}
