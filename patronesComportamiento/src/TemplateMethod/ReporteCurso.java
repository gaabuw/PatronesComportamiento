package TemplateMethod;

import entidades.Curso;

public class ReporteCurso extends ReporteAcademico{
    private Curso curso;
    private double notaPromedio; //En este directamente vamos a pasar una supuesta nota promedio entre todos los alumnos...

    public ReporteCurso (Curso curso, double notaPromedio){
        this.curso = curso;
        this.notaPromedio = notaPromedio;
    }

    @Override
    protected void contenido() {
        System.out.println("Curso: " + curso.getNombre());
        System.out.println("Cantidad de Alumnos inscriptos: " + curso.getObservers().size());
        System.out.println("Promedio general de notas: " + notaPromedio);
    }
}
