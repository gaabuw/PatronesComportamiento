package TemplateMethod;

import entidades.Alumno;

import java.util.List;

public class ReporteAlumno extends ReporteAcademico{
    private Alumno alumno;
    private List<Integer> notas;

    public ReporteAlumno(Alumno alumno, List<Integer> notas) {
        this.alumno = alumno;
        this.notas = notas;
    }


    @Override
    protected void contenido() {
        double notaPromedio = alumno.soloCalcular();

        System.out.println("Alumno: " + alumno.getNombre());
        System.out.println("Notas: " + notas);
        System.out.println("Promedio: " + notaPromedio);
        System.out.println("Estado: "+ ( notaPromedio >= 6 ? "Aprobado" : "Desaprobado"));
    }

}
