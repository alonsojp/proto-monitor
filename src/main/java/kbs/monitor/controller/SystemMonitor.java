package kbs.monitor.controller;

import com.sun.management.OperatingSystemMXBean;
import kbs.monitor.model.SysBean;

import java.lang.management.ManagementFactory;

/**
 * @author Jean-Pierre Alonso.
 */
public class SystemMonitor {

    private Runtime rt = Runtime.getRuntime();
//    private OperatingSystemMXBean osMXBean = ManagementFactory.getOperatingSystemMXBean();
    private OperatingSystemMXBean osMXBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    private SysBean sb;

    public SysBean systemSnapshot () {
        sb = new SysBean();

        sb.setCommittedMem(osMXBean.getCommittedVirtualMemorySize());
        sb.setTotalMem(rt.totalMemory());
        sb.setFreeMem(rt.freeMemory());
        sb.setUsedMem(sb.getTotalMem()-sb.getFreeMem());
        sb.setMaxMem(rt.maxMemory());
        sb.setFreePhMem(osMXBean.getFreePhysicalMemorySize());
        sb.setTotalPhMem(osMXBean.getTotalPhysicalMemorySize());
        sb.setAvailableProcessors(rt.availableProcessors());
        sb.setSysLoad(osMXBean.getSystemLoadAverage());
        sb.setCpuLoad(osMXBean.getProcessCpuLoad());
        sb.setCpuTime(osMXBean.getProcessCpuTime());
        return sb;
    }

    // the amount of used memory
    public long getUsedMem() {
        return rt.totalMemory()- rt.freeMemory();
    }

    // the amount of virtual memory that is guaranteed to be available to the running process in bytes, or -1 if this operation is not supported.
    public long getCommittedVirtualMemorySize() {
        return osMXBean.getCommittedVirtualMemorySize();
    }

    // the amount of free physical memory in bytes.
    public long getFreePhysicalMemorySize() {
        return osMXBean.getFreePhysicalMemorySize();
    }

    // the total amount of physical memory in bytes.
    public long getTotalPhysicalMemorySize(){
        return osMXBean.getTotalPhysicalMemorySize();
    }

    // the total amount of physical memory in bytes.
    public long getCpuTime(){
        return osMXBean.getProcessCpuTime();
    }
}
