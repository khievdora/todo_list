package dora.edu.domain.interactor;

import dora.edu.domain.MyEvent;
import dora.edu.domain.executor.PostExecutionThread;
import dora.edu.domain.executor.ThreadExecutor;
import dora.edu.domain.repository.EventRepository;
import io.reactivex.Observable;

/**
 * Created by Dora on 7/17/2017.
 */

public class AddEvent extends UseCase<MyEvent, MyEvent> {

    private EventRepository mEventRepository;

    public AddEvent(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                    EventRepository eventRepository) {
        super(threadExecutor, postExecutionThread);
        this.mEventRepository = eventRepository;
    }

    @Override
    Observable<MyEvent> buildUseCaseObservable(MyEvent event) {
        return this.mEventRepository.addEvent(event);
    }
}
