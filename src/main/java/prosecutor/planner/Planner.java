package prosecutor.planner;

import prosecutor.planner.event.Ticket;
import prosecutor.planner.storage.Store;
import prosecutor.planner.storage.jpa.TaskEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fry on 01.09.2016.
 */
public class Planner {

    private final PlannerOptions _options;

    public Planner(PlannerOptions plannerOptions)
    {
        this._options=plannerOptions;
    }
    protected Store getStore()
    {
        return _options.PersistTasks?_options.PersistDAO:NoStore.getInstance();
    }

    public Ticket executeTaskFromTemplate(String TaskTemplateID)
    {
        return null;
    }
    public Ticket executeTaskFromTemplate(String TaskTemplateID, TaskOptions taskDefinition)
    {
        return null;
    }
    public Ticket executeTaskFromTemplate(TaskTemplate template, TaskOptions taskOptions)
    {
        return null;
    }
    public Ticket executeTask(TaskDefinition taskDefinition)
    {
        return null;
    }
    public Task executeTaskFromTemplateAsync(String TaskTemplateID)
    {
        return null;
    }
    public Task executeTaskFromTemplateAsync(String TaskTemplateID, TaskDefinition taskDefinition)
    {
        return null;
    }
    public Task executeTaskAsync(TaskDefinition taskDefinition)
    {
        return null;
    }


    private static class NoStore implements Store
    {
        static NoStore instance;
        private static NoStore getInstance()
        {
            if(instance==null)
                instance=new NoStore();
            return instance;
        }
        private NoStore(){}

        @Override
        public TaskEntity createTask(TaskEntity entity) {
            return entity;
        }

        @Override
        public TaskEntity findTask(Integer ID) {
            return null;
        }

        @Override
        public TaskEntity updateTask(TaskEntity entity) {
            return entity;
        }

        @Override
        public List<TaskEntity> getAllTasks() {
            return new ArrayList<>();
        }

        @Override
        public void removeTask(Integer ID) {

        }

        @Override
        public void removeTask(TaskEntity entity) {

        }
    }
}
