package State;

import entidades.Inscripcion;

public class Cancelado  implements EstadoInscripcion{
    @Override
    public void cambiarEstado(Inscripcion inscripcion) {
        System.out.println("No se puede cambiar desde Cancelado.");
    }

    @Override
    public String getNombreEstado() {
        return "Cancelado";
    }
}
