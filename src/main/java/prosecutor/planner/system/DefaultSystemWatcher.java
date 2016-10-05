package prosecutor.planner.system;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**
 * Created by Fry on 02.09.2016.
 */
public class DefaultSystemWatcher {

    private OperatingSystemMXBean osBean;

    //region CONSTRUCTORS
    public DefaultSystemWatcher() {
        osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }
    //endregion

    public double getCPULoad()
    {
        return osBean.getSystemCpuLoad();
    }

    public double getFreePhysicalMemorySize()
    {
        return osBean.getFreePhysicalMemorySize();
    }

    public double getFreeSwapMemorySize()
    {
        return osBean.getFreeSwapSpaceSize();
    }

}
