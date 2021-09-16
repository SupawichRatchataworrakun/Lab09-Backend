package se331.lab.rest.config;

import com.sun.xml.txw2.annotation.XmlNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
            Organizer org1, org2, org3;
            org1 = organizerRepository.save(Organizer.builder()
                    .name("CAMT").build());
            org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
            org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());
                Event tempEvent;
                tempEvent = eventRepository.save(Event.builder()
                    .category("Academic")
                    .title("Midterm Exam")
                    .description("Have a bad day")
                    .location("Vanda Building")
                    .date("3rd Sept")
                    .time("3.00-4.00 pm.")
                    .petAllowed(false)
                    .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("Have a good day")
                .location("Home home")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("Test test")
                .location("Chiangmai")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Water ping")
                .location("Chiang Rai Rai")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
    }
}
