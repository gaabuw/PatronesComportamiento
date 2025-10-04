package State;

import entidades.Inscripcion;

public class EnEspera implements EstadoInscripcion {
    @Override
    public void cambiarEstado(Inscripcion inscripcion) {
        // por ejemplo, si hay cupo disponible se pasa a Inscrito
        System.out.println("Cambiando estado de EnEspera a Inscrito...");
        inscripcion.setEstado(new Inscrito());
    }

    @Override
    public String getNombreEstado() {
        return "EnEspera";
    }
}
