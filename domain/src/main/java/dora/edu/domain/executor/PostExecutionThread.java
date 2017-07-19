package dora.edu.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by Dora on 7/17/2017.
 */

public interface PostExecutionThread {

    Scheduler getScheduler();

}
