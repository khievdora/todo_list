package dora.edu.domain.repository;

import java.util.List;

import dora.edu.domain.Task;
import io.reactivex.Observable;

/**
 * Created by Dora on 6/22/2017.
 */

public interface TaskRepository {

    Observable<Task> getTaskById(String taskId);

    Observable<List<Task>> getTaskList();

}
