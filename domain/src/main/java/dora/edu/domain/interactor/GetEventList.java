package dora.edu.domain.interactor;

import java.util.List;

import dora.edu.domain.MyEvent;
import dora.edu.domain.executor.PostExecutionThread;
import dora.edu.domain.executor.ThreadExecutor;
import dora.edu.domain.repository.EventRepository;
import io.reactivex.Observable;

/**
 * Created by Dora on 7/17/2017.
 */

public class GetEventList extends UseCase<List<MyEvent>, Void> {

    private EventRepository mEventRepository;

    public GetEventList(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                        EventRepository eventRepository) {
        super(threadExecutor, postExecutionThread);
        this.mEventRepository = eventRepository;
    }

    @Override
    Observable<List<MyEvent>> buildUseCaseObservable(Void unused) {
        return this.mEventRepository.getEventList();
    }
}
