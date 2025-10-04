package entidades;

public class Solicitud {
    private String solicitud;
    private int nivel;

    public Solicitud(String solicitud, int nivel){
        this.solicitud = solicitud;
        this.nivel = nivel;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public int getNivel() {
        return nivel;
    }
}
