package Strategy;

import java.util.List;

public class PromedioSimple implements CalculoNota{
    @Override
    public double calcular(List<Integer> notas) {
        if(notas.isEmpty()) return 0;
        double sumaNotas = 0;
        for(int nota : notas){
            sumaNotas += nota ;
        }
        return sumaNotas / notas.size();
    }
}
