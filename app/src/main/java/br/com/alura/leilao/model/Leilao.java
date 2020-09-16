package br.com.alura.leilao.model;

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
        if (lanceNaoValido(lance)) return;
        lances.add(lance);
        double valorDoLance = lance.getValor();
        if (defineMaiorEMenorLanceParaOPrimeiroLance(valorDoLance)) return;
        Collections.sort(lances);
        calculaMaiorLance(valorDoLance);
        calculaMenorLance(valorDoLance);
    }

    private boolean defineMaiorEMenorLanceParaOPrimeiroLance(double valorDoLance) {
        if(lances.size() == 1){
            maiorLance = valorDoLance;
            menorLance = valorDoLance;
            return true;
        }
        return false;
    }

    private boolean lanceNaoValido(Lance lance) {
        double valorDoLance = lance.getValor();
        if (lanceForMenorQueOUltimoLance(valorDoLance)) return true;
        if(temLances()){
            Usuario usuarioNovo = lance.getUsuario();
            if (usuarioForOMesmoDoUltimoLance(usuarioNovo)) return true;
            if (usuarioDeuCincoLance(usuarioNovo)) return true;
        }
        return false;
    }

    private boolean temLances() {
        return !lances.isEmpty();
    }

    private boolean usuarioDeuCincoLance(Usuario usuarioNovo) {
        int lancesDoUsuario = 0;
        for(Lance l: lances){
            Usuario usuarioExistente = l.getUsuario();
            if(usuarioExistente.equals(usuarioNovo)){
                lancesDoUsuario++;
                if(lancesDoUsuario == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean usuarioForOMesmoDoUltimoLance(Usuario usuarioNovo) {
        Usuario ultimoUsuario = lances.get(0).getUsuario();
        if(usuarioNovo.equals(ultimoUsuario)){
            return true;
        }
        return false;
    }

    private boolean lanceForMenorQueOUltimoLance(double valorDoLance) {
        if(maiorLance > valorDoLance){
            return true;
        }
        return false;
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
