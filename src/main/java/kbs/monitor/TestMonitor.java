package kbs.monitor;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.concurrent.Task;
import kbs.monitor.controller.SystemMonitor;
import kbs.monitor.model.SysBean;
import kbs.monitor.model.SysBeanFX;

/**
 * @author Jean-Pierre Alonso.
 */
public class TestMonitor {
    private Thread th;
    private final ObjectProperty<SysBeanFX> sbfx;
    private boolean cancelled;
    private boolean mode_console;

    public TestMonitor(ObjectProperty<SysBeanFX> _sbfx) {
        sbfx = _sbfx;
    }

    public void start (boolean mode_console) {
        this.mode_console = mode_console;
        th = new Thread(new TestMonitorTask());
        th.setDaemon(true);
        th.start();
    }

    public void stop () {
        cancelled = true;
    }

    private class TestMonitorTask extends Task<Integer> {
        public Integer call() throws Exception {
            long start = System.nanoTime();
            long current;
            SystemMonitor sysMon = new SystemMonitor();

            while (!cancelled) {
                System.out.println(th.getState());
                SysBean sb = sysMon.systemSnapshot();
                current = System.nanoTime();
                // Display results on the console (optional)
                if (mode_console) {
                    sb.printState();
                    System.out.printf("elapsed time : %d ms", (current - start)/SysBean.NANO).println();
                }
                // Display results on the UI
                Platform.runLater(() -> sbfx.set(new SysBeanFX(sb)));
                try {
                    Thread.sleep(890);
                } catch (InterruptedException interrupted) {
                    if (cancelled) {
                        System.out.println("Cancelled");
//                        updateMessage("Cancelled");
                        break;
                    }
                }
            }
            cancelled = false;
            return 0;
        }
    }

    public SysBeanFX getSbfx() {
        return sbfx.get();
    }

    public ObjectProperty<SysBeanFX> sbfxProperty() {
        return sbfx;
    }
}
