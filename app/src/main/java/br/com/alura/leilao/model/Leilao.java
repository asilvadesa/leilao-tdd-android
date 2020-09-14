package br.com.alura.leilao.model;

import java.io.DataOutput;
import java.io.Serializable;
import java.util.ArrayList;
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
        double valorDoLance = lance.getValor();
        if(maiorLance < valorDoLance) {
            maiorLance = valorDoLance;
        }
        if(valorDoLance < menorLance){
            menorLance = valorDoLance;
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
}
