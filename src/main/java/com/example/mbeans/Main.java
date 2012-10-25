/* Main.java - main class for Hello World example.  Create the
   HelloWorld MBean, register it, then wait forever (or until the
   program is interrupted).  */

package com.example.mbeans;

import java.lang.management.ManagementFactory;

import javax.inject.Inject;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.monitoring.internal.implementation.jmx.MBeanManager;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;

@BusinessController
public class Main {
	
	@Inject
	private MBeanManager manager;
	
	@Startup
	public void setUp(){
		manager.registerNotificationListener(Hello.class, new Handler());
	}
	
	
	/*
	 * For simplicity, we declare "throws Exception". Real programs will usually
	 * want finer-grained exception handling.
	 */
	public static void main(String[] args) throws Exception {
		// Get the Platform MBean Server
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();


		// Construct the ObjectName for the MBean we will register
		ObjectName name = new ObjectName("com.example.mbeans:type=Hello");
		
		// Create the Hello World MBean
		Hello mbean = new Hello();

		// Register the Hello World MBean
		mbs.registerMBean(mbean, name);
		
		mbs.addNotificationListener(name, new Handler(), null,null);

		// Wait forever
		System.out.println("Waiting forever...");
		Thread.sleep(Long.MAX_VALUE);

	}
}