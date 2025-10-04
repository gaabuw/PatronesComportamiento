package State;

import entidades.Inscripcion;

public class Inscrito implements EstadoInscripcion {


    @Override
    public void cambiarEstado(Inscripcion inscripcion) {
        System.out.println("No se puede cambiar de estado desde Inscrito directamente.");
    }

    @Override
    public String getNombreEstado() {
        return "Inscrito";
    }
}
