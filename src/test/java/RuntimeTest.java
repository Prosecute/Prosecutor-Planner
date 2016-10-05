import prosecutor.planner.PlannerOptions;
import prosecutor.planner.TaskTemplate;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fry on 01.09.2016.
 */
public class RuntimeTest {

    public void optionSettingTest()
    {
        final TaskTemplate template=new TaskTemplate("Barrister") {{
            RedirectError = true;
            DefaultOutput = "%Destination%/output.txt";
            DefaultInput  = "%Source%/input.xml";
            DefaultError  = "%Destination%/error.txt";
            DefaultCommands = new ArrayList<String>(){{
                add("java -jar %Barrister%/Barrister.jar compare");
            }};
            Attributes = new HashMap<String, String>(){{
                put("Barrister","Barrister");
            }};
        }};

        PlannerOptions options=new PlannerOptions(){{
            DebugMode = true;
            ProcessWatchingInterval = 1_000;
            TaskTemplates = new HashSet<TaskTemplate>(){{
                add(template);
            }};
        }};
    }
}
