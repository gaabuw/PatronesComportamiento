package Command;

import entidades.Alumno;
import entidades.Curso;

public class AbandonarCursoCommand implements Command {
    private Gestor gestor;

    public AbandonarCursoCommand(Gestor gestor){
        this.gestor = gestor;
    }

    @Override
    public void execute(Alumno alumno, Curso c) {
        gestor.Abandonar(alumno,c);
    }
}
