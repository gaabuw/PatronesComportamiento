package TemplateMethod;

import java.time.LocalDate;

public abstract class ReporteAcademico {

    //Estructura General
    public final void generarReporte() {
        encabezado();
        contenido(); //El que vamos a personalizar
        pie();
    }

    //Pasos comunes
    protected void encabezado(){
        System.out.println("\n======= Reporte Académico =======");
        System.out.println("UTN: Facultad Regional Mendoza");
        System.out.println("Fecha: "+ LocalDate.now());
        System.out.println("-----------------------------------");
    };

    protected void pie(){
        System.out.println("------------------------------------");
        System.out.println("Fin del reporte");
        System.out.println("====================================\n");
    }

    //Metodo abstracto para que cada subclase implemente el suyo propio
    protected abstract void contenido();

}
