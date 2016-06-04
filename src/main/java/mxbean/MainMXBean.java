package mxbean;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 * @author Jean-Pierre Alonso.
 */
public class MainMXBean {

        public static void main(String[] args) {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

            ObjectName name;
            try {
                name = new ObjectName("monitor.mxbean:type=FirstMBean");

                First mbean = new First();

                mbs.registerMBean(mbean, name);

                System.out.println("Lancement ...");
                while (true) {

                    Thread.sleep(1000);
                    mbean.setValeur(mbean.getValeur() + 1);
                }
            } catch (MalformedObjectNameException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (InstanceAlreadyExistsException e) {
                e.printStackTrace();
            } catch (MBeanRegistrationException e) {
                e.printStackTrace();
            } catch (NotCompliantMBeanException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
            }
        }
}
