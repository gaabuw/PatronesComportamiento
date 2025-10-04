package Visitor;

import Mediator.ChatMediator;
import Strategy.CalculoNota;
import entidades.Alumno;

public class AlumnoRegular extends Alumno {
    public AlumnoRegular(ChatMediator mediator, String nombre, CalculoNota estrategia) {
        super(mediator, nombre, estrategia);
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitar(this);
    }
}
