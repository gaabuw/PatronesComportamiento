package Visitor;

import Mediator.ChatMediator;
import Strategy.CalculoNota;
import entidades.Alumno;

public class AlumnoBecado extends Alumno {
    private double porcentajeBeca;

    public AlumnoBecado(ChatMediator mediator, String nombre, CalculoNota estrategia, double porcentajeBeca) {
        super(mediator, nombre, estrategia);
        this.porcentajeBeca = porcentajeBeca;
    }

    public double getPorcentajeBeca() {
        return porcentajeBeca;
    }
    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitar(this);
    }

}
