package edu.asu.snac.serviceconsumer;

import java.util.Random;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import edu.asu.snac.simpleservice.SimpleServiceInterface;

public class Activator implements BundleActivator {

  Random r = new Random();

  /*
   * (non-Javadoc)
   * 
   * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  public void start(BundleContext context) throws Exception {
    ServiceReference ref = context.getServiceReference(SimpleServiceInterface.class.getName());
    if (ref == null) {
      System.out.println("Service not ready");
      return;
    }
    Object service = context.getService(ref);
    int a = r.nextInt();
    int b = r.nextInt();
    int c = ((SimpleServiceInterface) service).add(a, b);
    System.out.println("Call the service (" + a + ")+(" + b + ")=(" + c + ")");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
   */
  public void stop(BundleContext context) throws Exception {
    System.out.println("consumer stopping ..");
  }

}
