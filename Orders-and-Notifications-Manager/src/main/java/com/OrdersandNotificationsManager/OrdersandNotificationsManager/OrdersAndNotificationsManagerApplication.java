package com.OrdersandNotificationsManager.OrdersandNotificationsManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrdersAndNotificationsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersAndNotificationsManagerApplication.class, args);
	}
}
