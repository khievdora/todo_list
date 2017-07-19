package dora.edu.data.cache;

import dora.edu.data.entity.EventEntity;
import io.reactivex.Observable;

/**
 * Created by Dora on 7/18/2017.
 */

/**
 * This interface will present caching of event
 */
public interface EventCache {

    Observable<EventEntity> get(final int eventId);

    void put(EventEntity eventEntity);

    boolean isCache(final int eventId);

    boolean isExpired();

}
