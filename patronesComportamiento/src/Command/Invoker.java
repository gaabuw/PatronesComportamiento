package Command;

import entidades.Alumno;
import entidades.Curso;
import entidades.Usuario;

public class Invoker {

    public void accion(Command command, Curso c, Usuario alumno){
        command.execute((Alumno) alumno,c);
    }
}
