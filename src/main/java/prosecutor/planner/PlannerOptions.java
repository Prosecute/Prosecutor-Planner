package prosecutor.planner;

import prosecutor.optval.variables.ObjectTypes.*;
import prosecutor.optval.variables.Range;
import prosecutor.planner.storage.Store;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fry on 01.09.2016.
 */
public class PlannerOptions {

    public static Set<TaskTemplate>  TaskTemplates                  = new HashSet();
    public boolean                   DebugMode                      = false;
    @Range(Min = 0)
    public short                     MaxRunningTasks                =     10;
    @Range(Min = 0,Max = 100)
    public double                    MaxOverallCPUUsage             =     90;
    @Range(Min = 0)
    public int                       ProcessWatchingInterval        =    500;
    @Range(Min = 0)
    public int                       SystemWatchingActiveInterval   =  1_000;
    @Range(Min = 0)
    public int                       SystemWatchingPassiveInterval  = 10_000;

    public boolean                   PersistTasks                   = false;

    public Store                     PersistDAO                     = null;




}
