package prosecutor.planner.storage.jpa;

import prosecutor.planner.ITask;
import prosecutor.planner.Task;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

/**
 * Created by Fry on 02.09.2016.
 */
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int    TaskID;

    public List<String> Commands;

    public String OutputLoc;

    public String InputLoc;

    public String ErrorLoc;

    public Byte Priority;

    public Integer RepeatCount;

    public Integer RepeatInterval;

    public Integer Delay;


    public static TaskEntity fromITask(ITask... iTasks) {
        if (iTasks == null || iTasks.length == 0)
            return null;
        TaskEntity entity=new TaskEntity();
        entity.Commands = new ArrayList<String>();
        for (ITask iTask: iTasks) {
            for(String cmd:iTask.DefaultCommands)
                entity.Commands.add(cmd);
            if(entity.ErrorLoc==null)
                entity.ErrorLoc=iTask.DefaultError;
            if(entity.InputLoc==null)
                entity.InputLoc=iTask.DefaultInput;
            if(entity.OutputLoc==null)
                entity.OutputLoc=iTask.DefaultOutput;
            if(entity.Delay==null)
                entity.Delay=iTask.Delay;
            if(entity.Priority==null)
                entity.Priority=iTask.Priority;
            if(entity.RepeatCount==null)
                entity.RepeatCount=iTask.RepeatCount;
            if(entity.RepeatInterval==null)
                entity.RepeatInterval=iTask.RepeatInterval;
        }
        for(ITask iTask: iTasks)
        {
            for(Map.Entry<String,String> entry:iTask.Attributes.entrySet())
            {
                entity.OutputLoc=entity.OutputLoc.replaceAll("%"+entry.getKey()+"%",entry.getValue());
                entity.InputLoc=entity.InputLoc.replaceAll("%"+entry.getKey()+"%",entry.getValue());
                entity.ErrorLoc=entity.ErrorLoc.replaceAll("%"+entry.getKey()+"%",entry.getValue());
                for(int i=0;i<entity.Commands.size();i++)
                {
                    entity.Commands.set(i,entity.Commands.get(i).replaceAll("%"+entry.getKey()+"%",entry.getValue()));
                }
            }
        }
        return entity;
    }
}
