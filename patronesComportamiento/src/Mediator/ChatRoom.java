package Mediator;

import entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator{
    private List<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void enviarMensaje(String mensaje, Usuario usuario){
        for(Usuario u : usuarios){
            if(u != usuario){
                u.recibir(mensaje);
            }
        }
    }
}
