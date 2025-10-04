package Command;

import entidades.Alumno;
import entidades.Curso;

public class Gestor {
    public void Inscribirse(Alumno alumno, Curso c){
        if(alumno.getCursos().contains(c)){
            System.out.println("El alumno "+alumno.getNombre()+" ya está inscripto en el curso "+c.getNombre());
        } else{
            alumno.agregarCurso(c);
            System.out.println(alumno.getNombre() + " se inscribió en el curso de " + c.getNombre());
        }
    }
    public void Abandonar(Alumno alumno, Curso c){
        if (alumno.getCursos().contains(c)) {
            alumno.getCursos().remove(c);
            System.out.println(alumno.getNombre() + " abandonó el curso " + c.getNombre());
        } else {
            System.out.println("El alumno " + alumno.getNombre() + " no está inscrito en el curso " + c.getNombre());
        }
    }
    public void Certificado(Alumno alumno, Curso c){
        if (alumno.getCursos().contains(c)) {
            System.out.println("Certificado solicitado por " + alumno.getNombre() + " para el curso de " + c.getNombre());
        } else {
            System.out.println(alumno.getNombre() + " no está inscrito en el curso " + c.getNombre());
        }
    }
}
