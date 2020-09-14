package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    public static final double DELTA = 0.0001;
    public final Leilao CONSOLE = new Leilao("Console");

    @Test
    public void deve_DevolverDescricao_QuandoRecebeDescricao() {

        String descricaoDevolvida = CONSOLE.getDescricao();
        assertEquals("Console", CONSOLE.getDescricao());
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRececeApenasUmlance(){

        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        Double maiorLanceConsole = CONSOLE.getMaiorLance();
        assertEquals(200.0, maiorLanceConsole, 0.0001);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeLanceEmOrdemCrescente(){

        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 2000.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Maria"), 3000.0));
        Double maiorLanceComputador = CONSOLE.getMaiorLance();
        assertEquals(3000.0, maiorLanceComputador, DELTA);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeLanceEmOrdemDecrescente(){

        CONSOLE.proproeLance(new Lance(new Usuario("Maria"), 3000.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 2000.0));
        Double maiorLanceComputador = CONSOLE.getMaiorLance();
        assertEquals(3000.0, maiorLanceComputador, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRececeApenasUmlance(){

        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        Double maiorLanceConsole = CONSOLE.getMenorLance();
        assertEquals(200.0, maiorLanceConsole, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRececeLanceEmOrdemCrescente(){

        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Maria"), 300.0));
        Double maiorLanceConsole = CONSOLE.getMenorLance();
        assertEquals(200.0, maiorLanceConsole, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRececeLanceEmOrdemDecrescente(){

        CONSOLE.proproeLance(new Lance(new Usuario("Maria"), 300.0));
        CONSOLE.proproeLance(new Lance(new Usuario("Anderson"), 200.0));
        Double maiorLanceConsole = CONSOLE.getMenorLance();
        assertEquals(200.0, maiorLanceConsole, 0.0001);
    }

}