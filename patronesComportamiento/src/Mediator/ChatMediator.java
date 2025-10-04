package Mediator;

import entidades.Usuario;

public interface ChatMediator {
    void enviarMensaje(String msg, Usuario u);
    void agregarUsuario(Usuario usuario);
}
