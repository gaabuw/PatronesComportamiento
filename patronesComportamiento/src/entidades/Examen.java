package entidades;

import Memento.Memento;

public class Examen {
    public String examen = "";

    public void escribir (String respuesta){
        examen = respuesta;
    }

    public String getExamen() {
        return examen;
    }
    public Memento save(){
        return new Memento(examen);
    }
    public void restore(Memento m){
        examen = m.getEstado();
    }
}
