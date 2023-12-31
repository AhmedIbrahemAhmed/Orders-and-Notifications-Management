package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.Massage;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Notification.Message;

public interface HistoryRepositry {
    public void save(Message message);
    public String mostNotifiedEmail( );
   public String mostNotifiedPhoneNumber( );
   public String mostSentNotificationTemplate( );
}
