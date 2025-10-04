package entidades;

import Iterator.CursoIterator;
import Mediator.ChatMediator;
import Observer.Observer;
import Strategy.CalculoNota;
import Visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public abstract class Alumno extends Usuario implements Observer {
    private java.util.List<Curso> listaCursos = new java.util.ArrayList<>();
    private CalculoNota estrategia;
    private List<Integer> notas;


    public Alumno(ChatMediator mediator, String nombre, CalculoNota estrategia) {
        super(mediator, nombre);
        this.nombre = nombre;
        this.notas = new ArrayList<>(); //lista de notas vacias
        this.estrategia = estrategia;

    }
    // Permite agregar notas después
    public void agregarNota(int nota) {
        notas.add(nota);
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public List<Curso> getCursos() {
        return listaCursos;
    }
    public String getNombre() {
        return nombre;
    }

    public void agregarCurso(Curso c){
        listaCursos.add(c);
    }

    public CursoIterator iterator(){
        return new AlumnoIterator(listaCursos);
    }

    //Implementación del iterador interno
    private static class AlumnoIterator implements CursoIterator{
        private java.util.List<Curso> cursos;
        private int posicion = 0;

        public AlumnoIterator(java.util.List<Curso> cursos){
            this.cursos = cursos;
        }

        @Override
        public boolean hasNext() {
            return posicion < cursos.size();
        }

        @Override
        public Curso next() {
            return cursos.get(posicion++);
        }
    }
    //Metodos del ChatMediator
    public void enviar(String mensaje){
        System.out.println(nombre + " envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }
    public void recibir(String mensaje){
        System.out.println(nombre + " recibe: " + mensaje);
    }

    //Metodo del Observer
    @Override
    public void update(String msg) {
        String VERDE = "\u001B[35m";
        String RESET = "\u001B[0m";

        System.out.println(nombre + " tenes una nueva notificación: " + VERDE + msg + RESET);
    }


    //Metodo Stategy
    public void setEstrategia(CalculoNota estrategia){
        this.estrategia = estrategia;
    }
    public void calcular(){
        System.out.println("Promedio "+ estrategia.getClass().getSimpleName() +" de "+nombre+": "+ estrategia.calcular(notas));
    }

    //Prueba para el reporteAlumno
    public double soloCalcular(){
        return estrategia.calcular(notas);
    }

    //Metodo Visitor
    public abstract void aceptar(Visitor visitor);

}
