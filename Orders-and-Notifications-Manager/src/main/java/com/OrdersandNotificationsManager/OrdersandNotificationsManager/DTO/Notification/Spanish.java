package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Notification;

public class Spanish implements Language {
    @Override
    public String getLanguage() {
        return "Spanish";
    }

    @Override
    public String translate(String content) {
        String[] words = content.split("\\s+");
        if(words[0].equalsIgnoreCase("Dear")){
            return " Estimado $, Gracias por hacer un pedido en nuestra tienda ";
        }
        return " Hola $, ¡Buenas noticias! ¡Tu pedido con ID $ está en camino! ";
    }
}
