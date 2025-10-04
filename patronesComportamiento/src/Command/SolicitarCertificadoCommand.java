package Command;

import entidades.Alumno;
import entidades.Curso;

public class SolicitarCertificadoCommand implements Command {
    private Gestor gestor;

    public SolicitarCertificadoCommand(Gestor gestor){
        this.gestor = gestor;
    }

    @Override
    public void execute(Alumno alumno, Curso c) {gestor.Certificado(alumno,c);}
}
