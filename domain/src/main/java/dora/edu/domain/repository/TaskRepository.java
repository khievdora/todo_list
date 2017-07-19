package dora.edu.domain.repository;

import java.util.List;

import dora.edu.domain.MyTask;
import io.reactivex.Observable;

/**
 * Created by Dora on 6/22/2017.
 */

public interface TaskRepository {

    Observable<MyTask> getTaskById(String taskId);

    Observable<List<MyTask>> getTaskList();

}
