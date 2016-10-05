package prosecutor.planner;

import java.util.*;
import java.lang.ProcessBuilder.Redirect;

/**
 * Created by Fry on 01.09.2016.
 */
public class TaskTemplate {

    protected     ProcessBuilder _processBuilder;
    public        Map<String,String> Attributes                  = new HashMap<>();
    public        List<String>       DefaultCommands             = new ArrayList<>();
    public        String             DefaultOutput               = null;
    public        String             DefaultInput                = null;
    public        String             DefaultError                = null;
    public        boolean            RedirectError               = false;
    public final  String             TaskDefinitionID;

    public        Object         LockCreateTask              = new Object();

    public TaskTemplate(String taskDefinitionID)
    {
        this.TaskDefinitionID = taskDefinitionID;
    }

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
