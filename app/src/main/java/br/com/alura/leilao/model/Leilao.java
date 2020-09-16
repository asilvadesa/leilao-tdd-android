package br.com.alura.leilao.model;

import java.io.DataOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;
    private Double maiorLance = 0.0;
    private Double menorLance = 0.0;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public void proproeLance(Lance lance){
        double valorDoLance = lance.getValor();
        if(maiorLance > valorDoLance){
            return;
        }
        if(!lances.isEmpty()){
            Usuario usuarioNovo = lance.getUsuario();
            Usuario ultimoUsuario = lances.get(0).getUsuario();
            if(usuarioNovo.equals(ultimoUsuario)){
                return;
            }
        }

        lances.add(lance);
        if(lances.size() == 1){
            maiorLance = valorDoLance;
            menorLance = valorDoLance;
            return;
        }
        Collections.sort(lances);
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

    public int quantidadeDeLances() {
        return lances.size();
    }
}
