package entidades;

import Mediator.ChatMediator;
import Mediator.ChatRoom;

public abstract class Usuario {
    protected ChatMediator mediator;
    protected String nombre;

    public Usuario(ChatMediator mediator, String nombre){
        this.mediator = mediator;
        this.nombre = nombre;
    }

    public abstract void enviar(String mensaje);
    public abstract void recibir(String mensaje);

    public String getNombre() {
        return nombre;
    }
}
