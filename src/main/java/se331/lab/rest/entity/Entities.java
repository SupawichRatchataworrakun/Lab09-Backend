package se331.lab.rest.entity;

import java.util.List;

public class Entities {

    public class Organizer {
        Long id;
        String name;
        List<Event> ownEvents;
    }

    public class Participant {
        Long id;
        String name;
        String telNo;
        List<Event> eventHistory;
    }
}
