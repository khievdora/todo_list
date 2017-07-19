package dora.edu.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dora.edu.data.entity.EventEntity;
import dora.edu.domain.MyEvent;

/**
 * Created by Dora on 7/17/2017.
 */
@Singleton
public class EventEnityDataMapper {

    @Inject
    public EventEnityDataMapper() {

    }

    /**
     * Tansform object EventEntity into object MyEvent
     * @param eventEntity
     * @return
     */
    public MyEvent transform(EventEntity eventEntity) {
        MyEvent event = null;
        if (eventEntity != null) {
            event.setColorId(eventEntity.getEventId());
            event.setStartDate(eventEntity.getStartDate());
            event.setEndDate(eventEntity.getEndDate());
            event.setEventDescription(eventEntity.getEventDescription());
            event.setEventId(eventEntity.getEventId());
            event.setEventName(eventEntity.getEventName());
            event.setLocation(eventEntity.getLocation());
        }
        return event;
    }

    /**
     * Transform a list of {@link EventEntity} into collection of {@Link MyEvent}
     * @param eventEntities is a collection of EventEntity
     * @return a list of MyEvent
     */
    private List<MyEvent> transform(List<EventEntity> eventEntities) {
        List<MyEvent> eventList = null;
        if (eventEntities != null) {
            // By initialize the size of list will improve the performance and the allocation of
            // the memory.
            eventList = new ArrayList<>(20);
            for (EventEntity item : eventEntities) {
                eventList.add(transform(item));
            }
        }
        return eventList;
    }

}
