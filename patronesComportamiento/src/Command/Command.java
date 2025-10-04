package Command;

import entidades.Alumno;
import entidades.Curso;

public interface Command {
    public void execute(Alumno alumno, Curso c);
}
