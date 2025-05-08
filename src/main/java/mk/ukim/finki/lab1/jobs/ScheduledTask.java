package mk.ukim.finki.lab1.jobs;

import mk.ukim.finki.lab1.service.domain.AccommodationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    private final AccommodationService accommodationService;

    public ScheduledTask(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void refreshMaterializedView() {}
}
