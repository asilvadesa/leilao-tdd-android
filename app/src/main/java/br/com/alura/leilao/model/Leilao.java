package br.com.alura.leilao.model;

import java.io.DataOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;
    private Double maiorLance = Double.NEGATIVE_INFINITY;
    private Double menorLance = Double.POSITIVE_INFINITY;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public void proproeLance(Lance lance){
        lances.add(lance);
        Collections.sort(lances);
        double valorDoLance = lance.getValor();
        calculaMaiorLance(valorDoLance);
        calculaMenorLance(valorDoLance);
    }

    private void calculaMenorLance(double valorDoLance) {
        if(valorDoLance < menorLance){
            menorLance = valorDoLance;
        }
    }

    private void calculaMaiorLance(double valorDoLance) {
        if(maiorLance < valorDoLance) {
            maiorLance = valorDoLance;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getMaiorLance() {
        return maiorLance;
    }

    public Double getMenorLance() {
        return menorLance;
    }

    public List<Lance> devolveListaTresMaioresLances() {
        int tamanhoDaLista = lances.size();
        if(tamanhoDaLista > 3){
            tamanhoDaLista = 3;
        }
        return lances.subList(0, tamanhoDaLista);
    }
}
