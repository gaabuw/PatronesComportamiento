package Visitor;

public class AplicarBeca implements Visitor{
    @Override
    public void visitar(AlumnoRegular a) {
        System.out.println("No aplica beca. Alumno regular: " + a.getNombre());
    }

    @Override
    public void visitar(AlumnoBecado a) {
        System.out.println("Aplicando beca del " + a.getPorcentajeBeca() + "% al alumno: " + a.getNombre());

    }
}
