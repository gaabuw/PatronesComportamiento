package entidades;

import Memento.Memento;

public class Historial {
    private java.util.Stack<Memento> historial = new java.util.Stack<>();

    public void save(Memento m){
        historial.push(m);
    }
    public Memento restore(){
        if(!historial.isEmpty()){
            return  historial.pop();
        }
        return null;
    }




}
