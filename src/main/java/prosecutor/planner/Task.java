package prosecutor.planner;


import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Fry on 01.09.2016.
 */
public class Task {

    //region VARIABLES
    private   ProcessBuilder _processBuilder = null;
    protected Process        _process        = null;
    public    AtomicBoolean  Running         = null;
    public    AtomicLong     RunnedTime     = null;
    public    AtomicLong     StartTime       = null;
    public    AtomicInteger  ExitCode        = null;
    public    AtomicBoolean  Started         = new AtomicBoolean(false);
    //endregion

    //region CONSTRUCTORS
    protected Task(TaskTemplate definition){
        this._processBuilder = definition._processBuilder;
    }
    //endregion


    protected void start()
    {
        TaskThread taskThread=new TaskThread(this);
        taskThread.start();
    }

    //region INNER_CLASSES
    protected class TaskThread extends Thread
    {
        private Task _task;

        public TaskThread(Task task)
        {
            this._task=task;
        }
        @Override
        public void run() {
            try {
                int exitCode = -1;
                Process process = _task._processBuilder.start();
                _task._process = process;

                _task.StartTime.lazySet(System.currentTimeMillis());
                _task.Running.lazySet(true);
                _task.Started.lazySet(true);

                try {
                    exitCode = process.waitFor();
                }
                catch (InterruptedException e)
                {

                }

                _task.RunnedTime.set(System.currentTimeMillis()-_task.StartTime.get());
                _task.ExitCode.set(exitCode);
                _task.Running.set(false);
            }
            catch (IOException e)
            {
            }
        }
    }
    //endregion
}
