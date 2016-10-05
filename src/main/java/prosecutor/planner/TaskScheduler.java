package prosecutor.planner;

import prosecutor.planner.system.SystemWatcher;

/**
 * Created by Fry on 02.09.2016.
 */
public class TaskScheduler extends Thread {

    private final SystemWatcher SystemWatcher;

    protected byte MaxCPUUsageByTask;

    public TaskScheduler(SystemWatcher systemWatcher)
    {
        this.SystemWatcher = systemWatcher;
    }

    @Override
    public void run() {

    }
}
