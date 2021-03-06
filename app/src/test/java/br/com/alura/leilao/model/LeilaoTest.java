package br.com.alura.leilao.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {


    public static final double DELTA = 0.0001;
    public final Leilao CONSOLE = new Leilao("Console");

    @Test
    public void deve_DevolveDescricao_QuandoRecebeDescricao() {

        String descricaoDevolvida = CONSOLE.getDescricao();
        assertEquals("Console", CONSOLE.getDescricao());
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRececeApenasUmlance(){

        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        Double maiorLanceConsole = CONSOLE.getMaiorLance();
        assertEquals(200.0, maiorLanceConsole, DELTA);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeLanceEmOrdemCrescente(){

        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 2000.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Maria"), 3000.0));
        Double maiorLanceComputador = CONSOLE.getMaiorLance();
        assertEquals(3000.0, maiorLanceComputador, DELTA);
    }


    @Test
    public void deve_DevolveMenorLance_QuandoRececeApenasUmlance(){

        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        Double maiorLanceConsole = CONSOLE.getMenorLance();
        assertEquals(200.0, maiorLanceConsole, DELTA);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRececeLanceEmOrdemCrescente(){

        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Maria"), 300.0));
        Double maiorLanceConsole = CONSOLE.getMenorLance();
        assertEquals(200.0, maiorLanceConsole, DELTA);
    }

    @Test
    public void deve_DevolveTresMaioresLances_QuandoRecebeTresLances(){
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Maria"), 300.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 350.0));

        List<Lance> listaDeTresMaioresLances =  CONSOLE.devolveListaTresMaioresLances();

        assertEquals(3, listaDeTresMaioresLances.size());
        assertEquals(350.0, listaDeTresMaioresLances.get(0).getValor(), DELTA);
        assertEquals(300.0, listaDeTresMaioresLances.get(1).getValor(), DELTA);
        assertEquals(200.0, listaDeTresMaioresLances.get(2).getValor(), DELTA);
    }

    @Test
    public void deve_DevolveTresMaioresLances_QuandoNaoRecebeLance(){
        List<Lance> listaDeTresMaioresLances =  CONSOLE.devolveListaTresMaioresLances();
        assertEquals(0, listaDeTresMaioresLances.size());
    }

    @Test
    public void deve_DevovleTresMaioresLances_QuandoRecebeUmLance(){
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        List<Lance> listaDeTresMaioresLances =  CONSOLE.devolveListaTresMaioresLances();
        assertEquals(1, listaDeTresMaioresLances.size());
        assertEquals(200, listaDeTresMaioresLances.get(0).getValor(), DELTA);
    }

    @Test
    public void deve_DevovleTresMaioresLances_QuandoRecebeDoisLance(){
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Fran"), 500.0));
        List<Lance> listaDeTresMaioresLances =  CONSOLE.devolveListaTresMaioresLances();
        assertEquals(2, listaDeTresMaioresLances.size());
        assertEquals(500, listaDeTresMaioresLances.get(0).getValor(), DELTA);
    }

    @Test
    public void deve_DevovleTresMaioresLances_QuandoRecebeMaisDeTresLances(){
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Alex"), 500.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 800.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Mario"), 1000.0));

        List<Lance> listaDeTresMaioresLances =  CONSOLE.devolveListaTresMaioresLances();
        assertEquals(3, listaDeTresMaioresLances.size());
        assertEquals(1000, listaDeTresMaioresLances.get(0).getValor(), DELTA);
        assertEquals(800, listaDeTresMaioresLances.get(1).getValor(), DELTA);
        assertEquals(500, listaDeTresMaioresLances.get(2).getValor(), DELTA);
    }

    @Test
    public void deve_DevolveValorZeroParaMaiorLance_QuandoNaoTiverLances(){
        Double maiorLanceDevolvido = CONSOLE.getMaiorLance();
        assertEquals(0.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveValorZeroParaMenorLance_QuandoNaoTiverLance(){
        Double menorLanceDevolvido = CONSOLE.getMenorLance();
        assertEquals(0.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void naoDeve_AdcionarLance_QuandoForMenorQueMaiorLance(){
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 500.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 400.0));
        int quantidadeDeLancesDevolvida = CONSOLE.quantidadeDeLances();
        assertEquals(1, quantidadeDeLancesDevolvida);
    }

    @Test
    public void naoDeve_adicionarLance_QuandoForOMesmoUsuarioDoUltimoLance(){
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 400.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 500.0));

        int quantidadeDeLancesDevolvida = CONSOLE.quantidadeDeLances();

        assertEquals(1, quantidadeDeLancesDevolvida);
    }

    @Test
    public void naoDeve_AdicionarLance_QuandoUsuarioDerCincoLance(){
        final String ANDERSON = "Anderson";
        final String MARIA = "Maria";
        CONSOLE.proproeLance(new Lance(new Usuario(ANDERSON), 100.0));
        CONSOLE.proproeLance(new Lance(new Usuario(MARIA), 200.0));
        CONSOLE.proproeLance(new Lance(new Usuario(ANDERSON), 300.0));
        CONSOLE.proproeLance(new Lance(new Usuario(MARIA), 400.0));
        CONSOLE.proproeLance(new Lance(new Usuario(ANDERSON), 500.0));
        CONSOLE.proproeLance(new Lance(new Usuario(MARIA), 600.0));
        CONSOLE.proproeLance(new Lance(new Usuario(ANDERSON), 700.0));
        CONSOLE.proproeLance(new Lance(new Usuario(MARIA), 800.0));
        CONSOLE.proproeLance(new Lance(new Usuario(ANDERSON), 900.0));
        CONSOLE.proproeLance(new Lance(new Usuario(MARIA), 1000.0));

        CONSOLE.proproeLance(new Lance(new Usuario(ANDERSON), 1100.0));
        CONSOLE.proproeLance(new Lance(new Usuario(MARIA), 1200.0));

        int quantidadeDeLancesDevolvida = CONSOLE.quantidadeDeLances();

        assertEquals(10, quantidadeDeLancesDevolvida);

    }

}