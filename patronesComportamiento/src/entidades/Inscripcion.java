package entidades;

import State.EnEspera;
import State.EstadoInscripcion;

public class Inscripcion {
    private Alumno alumno;
    private Curso curso;
    private EstadoInscripcion estado;

    public Inscripcion(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
        this.estado = new EnEspera(); // estado inicial
    }
    public void setEstado(EstadoInscripcion estado) {
        this.estado = estado;
    }

    public EstadoInscripcion getEstado() {
        return estado;
    }

    public void cambiarEstado() {
        estado.cambiarEstado(this);
    }

    public void mostrarEstado() {
        System.out.println("Alumno: " + alumno.getNombre() +
                ", Curso: " + curso.getNombre() +
                ", Estado: " + estado.getNombreEstado());
    }
}
