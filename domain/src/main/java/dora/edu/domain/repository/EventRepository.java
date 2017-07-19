package dora.edu.domain.repository;

import java.util.List;

import dora.edu.domain.MyEvent;
import io.reactivex.Observable;

/**
 * Created by Dora on 6/4/2017.
 */

/**
 * EventRepository is an interface for getting data related to event
 */
public interface EventRepository {

    Observable<MyEvent> getEventById(String eventId);

    Observable<List<MyEvent>> getEventList();

    Observable<MyEvent> addEvent(MyEvent event);

}
