package Notifications;

public class Spanish implements Language {
    @Override
    public String translate(String content) {
        String[] words = content.split("\\s+");
        if(words[0].equalsIgnoreCase("Dear")){
            return " Estimado $, Gracias por hacer un pedido en nuestra tienda ";
        }
        else{
            return " Hola $, ¡Buenas noticias! ¡Tu pedido con ID $ está en camino! ";
        }
    }
}
