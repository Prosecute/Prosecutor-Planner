package prosecutor.planner.storage;

import prosecutor.planner.Task;
import prosecutor.planner.storage.jpa.TaskEntity;

import java.util.List;

/**
 * Created by Fry on 02.09.2016.
 */
public interface Store {
    public TaskEntity createTask(TaskEntity entity);
    public TaskEntity findTask(Integer ID);
    public TaskEntity updateTask(TaskEntity entity);
    public List<TaskEntity> getAllTasks();
    public void removeTask(Integer ID);
    public void removeTask(TaskEntity entity);
}
