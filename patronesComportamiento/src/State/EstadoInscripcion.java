package State;

import entidades.Inscripcion;

public interface EstadoInscripcion {
    void cambiarEstado(Inscripcion inscripcion);
    String getNombreEstado();
}
