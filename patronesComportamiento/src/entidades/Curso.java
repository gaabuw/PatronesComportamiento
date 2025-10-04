package entidades;

import Observer.Observer;
import Observer.Subject;

import java.util.*;

public class Curso implements Subject {
    private String nombre;
    private List<Observer> observers = new ArrayList<>();
    private String notificacion;

    public Curso(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void setNotificacion(String notificacion){
        this.notificacion = notificacion;
        notifyObservers();
    }
    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update("[" + nombre + "] " + notificacion);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
