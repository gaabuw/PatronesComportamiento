package entidades;

import ChainOfResponsibility.Handler;
import Mediator.ChatMediator;

public class Profesor extends Usuario implements Handler{
    private Handler next;

    public Profesor(ChatMediator mediator, String nombre){
        super(mediator,nombre);
    }

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Solicitud s) {
        if(s.getNivel() == 2){
            System.out.println("Un profesor gestionara la solitud: " + s.getSolicitud());
            return;
        }
        next.handle(s);
    }
    //Metodos del ChatMediator
    public void enviar(String mensaje){
        System.out.println(nombre + " envía: " + mensaje);
        mediator.enviarMensaje(mensaje,this);
    }
    public void recibir(String mensaje){
        System.out.println(nombre + " recibe: " + mensaje);
    }
}
