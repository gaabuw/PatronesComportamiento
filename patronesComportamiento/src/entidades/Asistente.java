package entidades;

import ChainOfResponsibility.Handler;
import Mediator.ChatMediator;

public class Asistente extends Usuario implements Handler {
    private Handler next;

    public Asistente(ChatMediator mediator, String nombre) {
        super(mediator, nombre);
    }

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }
    @Override
    public void handle(Solicitud s) {
        if(s.getNivel() <= 1){
            System.out.println("Un asistente gestionara la solicitud: " + s.getSolicitud());
            return;
        }
        next.handle(s);
    }

    @Override
    public void enviar(String mensaje) {
    }
    @Override
    public void recibir(String mensaje) {
    }
}
