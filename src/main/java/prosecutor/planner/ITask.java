package prosecutor.planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Fry on 12.10.2016.
 */
public abstract class ITask {

    public        Map<String,String> Attributes                  = new HashMap();
    public        List<String> DefaultCommands                   = new ArrayList();
    public        String             DefaultOutput               = null;
    public        String             DefaultInput                = null;
    public        String             DefaultError                = null;
    public        byte               Priority                    = 0x00;
    public        Integer            RepeatCount                 = 0x01;
    public        Integer            RepeatInterval              = 0xFF;
    public        Integer            Delay                       = 0x00;

}
