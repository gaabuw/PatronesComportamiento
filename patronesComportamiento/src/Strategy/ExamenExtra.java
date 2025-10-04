package Strategy;

import java.util.List;

public class ExamenExtra implements CalculoNota{
    private int examenExtra;

    public ExamenExtra(int examenExtra){
        this.examenExtra = examenExtra;
    }

    @Override
    public double calcular(List<Integer> notas) {
        double promedio = 0;
        notas.add(9);
        for(int nota : notas){
            promedio += nota;
        }
        return promedio / notas.size();
    }
}
