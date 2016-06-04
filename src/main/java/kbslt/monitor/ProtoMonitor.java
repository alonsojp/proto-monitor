package kbslt.monitor;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import kbslt.monitor.controller.SystemMonitor;
import kbslt.monitor.model.SysBean;
import kbslt.monitor.model.SysBeanFX;

/**
 * @author Jean-Pierre Alonso.
 */
public class ProtoMonitor implements IProtoMonitor {
    private Thread th;
    private ObjectProperty<SysBeanFX> sbfx = new SimpleObjectProperty<>(new SysBeanFX());
    private boolean cancelled;
    private boolean mode_console;

    @Override
    public void start (boolean mode_console) {
        this.mode_console = mode_console;
        th = new Thread(new TestMonitorTask());
        th.setDaemon(true);
        th.start();
    }

    @Override
    public void stop () {
        cancelled = true;
    }

    public SysBeanFX getSbfx() {
        return sbfx.get();
    }

    public ObjectProperty<SysBeanFX> sbfxProperty() {
        return sbfx;
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
                    System.out.printf("elapsed time : %d ms", (current - start) / SysBean.NANO).println();
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
}
