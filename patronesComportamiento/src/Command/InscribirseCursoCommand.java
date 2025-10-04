package Command;

import entidades.Alumno;
import entidades.Curso;

public class InscribirseCursoCommand implements Command {
    private Gestor gestor;


    public InscribirseCursoCommand(Gestor gestor){
        this.gestor = gestor;
    }

    @Override
    public void execute(Alumno alumno, Curso c) {gestor.Inscribirse(alumno,c);}
}
