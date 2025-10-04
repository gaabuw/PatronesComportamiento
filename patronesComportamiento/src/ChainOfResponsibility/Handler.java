package ChainOfResponsibility;

import entidades.Solicitud;

public interface Handler {
    public void setNext(Handler next);
    public void handle(Solicitud s);
}
