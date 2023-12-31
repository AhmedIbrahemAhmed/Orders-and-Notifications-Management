package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications;

public interface HistoryRepositry {
    public void save(Message message);
    public String mostNotifiedEmail( );
   public String mostNotifiedPhoneNumber( );
   public String mostSentNotificationTemplate( );
}
