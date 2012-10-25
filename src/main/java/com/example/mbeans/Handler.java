package com.example.mbeans;

import java.util.ArrayList;

import javax.management.Notification;
import javax.management.NotificationListener;

class Handler implements NotificationListener {

	private ArrayList<Notification> notificationOrder = new ArrayList<Notification>();

	public void handleNotification(Notification notification, Object handback) {
		notificationOrder.add((int)notification.getSequenceNumber(), notification);
		
		handleAssynchronous();
	}
	
	public void handleAssynchronous(){
		
	}

}
