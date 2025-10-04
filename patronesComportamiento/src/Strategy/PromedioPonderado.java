package Strategy;

import java.util.List;

public class PromedioPonderado implements CalculoNota{
    private List<Double> pesos;

    public PromedioPonderado(List<Double> pesos){
        this.pesos = pesos;
    }

    @Override
    public double calcular(List<Integer> notas) {
        if(notas.isEmpty() || notas.size() != pesos.size()) return 0;
        double total = 0;
        for(int i=0; i < notas.size(); i++){
           total += notas.get(i) * pesos.get(i);
        }
        return total;
    }
}
