package se331.lab.rest.config;

import com.sun.xml.txw2.annotation.XmlNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;


@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;
    @Autowired
    ParticipantRepository participantRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
            Organizer org1, org2, org3;
            Participant par1, par2, par3, par4, par5;
            org1 = organizerRepository.save(Organizer.builder()
                    .name("CAMT").build());
            org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());  
            org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());
            par1 = participantRepository.save(Participant.builder().name("Test").telNo("0805874615").build());
            par2 = participantRepository.save(Participant.builder().name("Army").telNo("0801485236").build());
            par3 = participantRepository.save(Participant.builder().name("Vanda").telNo("0801197456").build());
            par4 = participantRepository.save(Participant.builder().name("GOGO").telNo("0136661236").build());
            par5 = participantRepository.save(Participant.builder().name("Woo").telNo("0801422748").build());
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
        par1.getEventHistory().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
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
        par1.getEventHistory().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
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
        par1.getEventHistory().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
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
        par3.getEventHistory().add(tempEvent);
        par4.getEventHistory().add(tempEvent);
        par5.getEventHistory().add(tempEvent);
    }
}
