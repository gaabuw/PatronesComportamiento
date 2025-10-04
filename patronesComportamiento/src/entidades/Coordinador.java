package entidades;

import ChainOfResponsibility.Handler;
import Mediator.ChatMediator;

public class Coordinador extends Usuario implements Handler {
    private Handler next;

    public Coordinador(ChatMediator mediator, String nombre) {
        super(mediator, nombre);
    }

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Solicitud s) {
        if(s.getNivel() == 3){
            System.out.println("Un coordinador gestionara la solicitud: " + s.getSolicitud());
        } else {
            System.out.println("No se puede gestionar la solicitud: " + s.getSolicitud());
        }
    }
    //Metodos del ChatMediator
    public void enviar(String mensaje){
        System.out.println(nombre + " envía: " + mensaje);
    }
    public void recibir(String mensaje){
        System.out.println(nombre + " recibe: " + mensaje);
    }
}
