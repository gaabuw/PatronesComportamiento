import ChainOfResponsibility.Handler;
import Mediator.ChatMediator;
import Mediator.ChatRoom;
import Observer.Observer;
import State.Cancelado;
import Strategy.ExamenExtra;
import Strategy.PromedioPonderado;
import Strategy.PromedioSimple;
import TemplateMethod.ReporteAcademico;
import TemplateMethod.ReporteAlumno;
import TemplateMethod.ReporteCurso;
import Visitor.AlumnoBecado;
import Visitor.AlumnoRegular;
import entidades.Asistente;
import entidades.Coordinador;
import entidades.Profesor;
import Command.AbandonarCursoCommand;
import Command.InscribirseCursoCommand;
import Command.SolicitarCertificadoCommand;
import Command.Command;
import Command.Invoker;
import Command.Gestor;

import Iterator.CursoIterator;
import entidades.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //INICIAMOS EL SISTEMA
        System.out.println("======== Plataforma de Aprendizaje en Línea ========");
        ChatMediator sala = new ChatRoom();//Este es del MEDIATOR

        //// /////CHAIN OF RESPONSIBILITY
        //Handlers
        Usuario asistente = new Asistente(sala,"Gustavo");
        Usuario profesor = new Profesor(sala,"Jorge");
        Usuario coordinador = new Coordinador(sala,"Manuel");

        //Cadena
        ((Asistente) asistente).setNext((Handler) profesor);
        ((Profesor) profesor).setNext((Handler) coordinador);

        //Solicitudes
        Solicitud s1 = new Solicitud("Consulta sobre unos ejercicios", 1);
        Solicitud s2 = new Solicitud("Revisión de notas finales", 2);
        Solicitud s3 = new Solicitud("Dudas sobre la carrera", 3);
        Solicitud s4 = new Solicitud("Problemas con el Campus", 4);

        //Probamos
        ((Asistente) asistente).handle(s1);
        ((Asistente) asistente).handle(s2);
        ((Asistente) asistente).handle(s3);
        ((Asistente) asistente).handle(s4);

        //// ///// COMMAND
        System.out.println("");
        Gestor gestor = new Gestor();
        Invoker invoker = new Invoker();

        //Agrego Cursos y Alumnos
        Curso fisica = new Curso("Fisica");
        Curso desarrollo = new Curso("Desarrollo");
        Curso analisis = new Curso("Analisis");

        //Usuario a1 = new Alumno(sala,"Gabriel",new PromedioSimple());
        AlumnoRegular a1 = new AlumnoRegular(sala, "Gabriel", new PromedioSimple());
        //Creo los commands
        Command inscribir = new InscribirseCursoCommand(gestor);
        Command certificado = new SolicitarCertificadoCommand(gestor);
        Command abandonar = new AbandonarCursoCommand(gestor);

        //invoker
        invoker.accion(inscribir,fisica,a1);
        invoker.accion(inscribir,desarrollo,a1);
        invoker.accion(inscribir,analisis,a1);
        invoker.accion(abandonar,fisica,a1);
        invoker.accion(certificado,desarrollo,a1);

        //// ///// ITERATOR
        System.out.println("\nCursos de "+a1.getNombre()+":");
        CursoIterator it = ((Alumno) a1).iterator();
        while (it.hasNext()) {
            System.out.println("-"+it.next().getNombre());
        }
        System.out.println("\n");

        //// ///// MEDIATOR
        sala.agregarUsuario(profesor);
        sala.agregarUsuario(asistente);
        sala.agregarUsuario(coordinador);
        sala.agregarUsuario(a1);

        profesor.enviar("Hola a todos");
        //a1.enviar("Buenas tardes");

        //// ///// MEMENTO
        System.out.println("\n");
        Examen examen1 = new Examen();
        Historial historial = new Historial();

        examen1.escribir("2+2=3");
        historial.save(examen1.save());
        System.out.println("Guardado 1: "+examen1.getExamen());

        examen1.restore(historial.restore());
        examen1.escribir("2+2=4");
        historial.save(examen1.save());
        System.out.println("Guardado 2: "+examen1.getExamen());

        //// ///// OBSERVER
        System.out.println("\n");
        desarrollo.addObserver((Observer) a1);
        analisis.addObserver((Observer) a1);

        desarrollo.setNotificacion("Mañana no tendran clases");
        analisis.setNotificacion("El día miercoles habra examen");

        //// ///// STATE // Este lo hice separado.. tendria que estar junto al de Command
        System.out.println("\n");

        Inscripcion inscripcion = new Inscripcion((Alumno) a1,desarrollo);
        inscripcion.mostrarEstado(); //EnEspera

        inscripcion.cambiarEstado(); //pasa a Inscrito
        inscripcion.mostrarEstado(); //Inscrito

        inscripcion.setEstado(new Cancelado());
        inscripcion.mostrarEstado(); //Cancelado

        //// ///// STRATEGY
        System.out.println("\n");
        //Agregamos notas
        ((Alumno) a1).agregarNota(5);
        ((Alumno) a1).agregarNota(7);
        ((Alumno) a1).agregarNota(9);

        //Calculamos nota con Promedio Simple
        ((Alumno) a1).calcular();

        //Calculamos nota con Promedio Ponderado
        ((Alumno) a1).setEstrategia(new PromedioPonderado(Arrays.asList(0.5,0.3,0.2)));
        ((Alumno) a1).calcular();

        //Cambiamos estrategia a examen extra (nota examen = 9)
        ((Alumno) a1).setEstrategia(new ExamenExtra(9));
        ((Alumno) a1).calcular();

        //// ///// TEMPLATE METTHOD
        ReporteAcademico reporteCursoDesarrollo = new ReporteCurso(desarrollo, 7.8);
        ReporteAcademico reporteAlumno = new ReporteAlumno((Alumno) a1,((Alumno) a1).getNotas());

        reporteCursoDesarrollo.generarReporte();
        reporteAlumno.generarReporte();

        //// ///// VISITOR

        System.out.println("\n");
        Visitor.AplicarBeca aplicarBeca = new Visitor.AplicarBeca();

        //Probamos alumno Regular
        a1.aceptar(aplicarBeca);

        //Probamos alumno Becado
        AlumnoBecado a2 = new AlumnoBecado(sala, "Leandro", new PromedioSimple(), 0.5);
        a2.aceptar(aplicarBeca);

    }
}
