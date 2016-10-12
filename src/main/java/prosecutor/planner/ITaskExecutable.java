package prosecutor.planner;

import prosecutor.planner.Task;

/**
 * Created by Fry on 12.10.2016.
 */
public abstract class ITaskExecutable extends ITask{

    protected     ProcessBuilder _processBuilder                 = null;
    public        Object         LockCreateTask                  = new Object();

    public Task createTask()
    {
        Task task = null;
        synchronized (LockCreateTask) {
            _processBuilder = new ProcessBuilder(); //This two lines are reason why we use synchronized block
            task = new Task(this);                  //
        }
        return task;
    }
}
