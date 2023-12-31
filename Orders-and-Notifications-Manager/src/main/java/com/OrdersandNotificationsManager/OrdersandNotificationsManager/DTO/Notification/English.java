package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Notification;

public class English implements Language {
    @Override
    public String getLanguage() {
        return "English";
    }

    @Override
    public String translate(String content) {
        return content;
    }
}
