package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Notification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public interface Language {
    public String getLanguage();
    public String translate(String content);
}
