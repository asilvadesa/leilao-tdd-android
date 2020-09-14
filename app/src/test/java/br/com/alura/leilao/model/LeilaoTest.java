package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void deve_DevolverDescricao_QuandoRecebeDescricao() {
        Leilao console = new Leilao("Console");
        String descricaoDevolvida = console.getDescricao();
        assertEquals("Console", console.getDescricao());
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRececeApenasUmlance(){
        Leilao console = new Leilao("Console");
        console.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        Double maiorLanceConsole = console.getMaiorLance();
        assertEquals(200.0, maiorLanceConsole, 0.0001);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeLanceEmOrdemCrescente(){
        Leilao computador = new Leilao("Computador");
        computador.proproeLance(new Lance(new Usuario("Anderson"), 2000.0));
        computador.proproeLance(new Lance(new Usuario("Maria"), 3000.0));
        Double maiorLanceComputador = computador.getMaiorLance();
        assertEquals(3000.0, maiorLanceComputador, 0.0001);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeLanceEmOrdemDecrescente(){
        Leilao computador = new Leilao("Computador");
        computador.proproeLance(new Lance(new Usuario("Maria"), 3000.0));
        computador.proproeLance(new Lance(new Usuario("Anderson"), 2000.0));
        Double maiorLanceComputador = computador.getMaiorLance();
        assertEquals(3000.0, maiorLanceComputador, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRececeApenasUmlance(){
        Leilao console = new Leilao("Console");
        console.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        Double maiorLanceConsole = console.getMenorLance();
        assertEquals(200.0, maiorLanceConsole, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRececeLanceEmOrdemCrescente(){
        Leilao console = new Leilao("Console");
        console.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        console.proproeLance(new Lance(new Usuario("Maria"), 300.0));
        Double maiorLanceConsole = console.getMenorLance();
        assertEquals(200.0, maiorLanceConsole, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRececeLanceEmOrdemDecrescente(){
        Leilao console = new Leilao("Console");
        console.proproeLance(new Lance(new Usuario("Maria"), 300.0));
        console.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        Double maiorLanceConsole = console.getMenorLance();
        assertEquals(200.0, maiorLanceConsole, 0.0001);
    }

}