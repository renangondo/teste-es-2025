package br.edu.ifpr.teste.servico.irpf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import imposto.renda.SimuladorImpostoRenda;

public class TesteSimuladorImpostoRenda {
    @Test
    public void exemploTeste() {
        // Arrange (PREPARAR) - Roy Osherove no livro “The Art of Unit Testing”.
        // Given (DADO) - BDD (Behavior Driven Development)

        // Act (AGIR)
        // When (QUANDO)

        SimuladorImpostoRenda.calcularImposto(0);
        // Assert (VERIFICAR)
        // Then (ENTÃO)
    }
    //Teste exercício 6

     @Test
    public void testFaixaIsenta() {
        double resultado = SimuladorImpostoRenda.calcularImposto(1800.00);
        assertEquals(0.0, resultado, 0.01);
    }

    @Test
    public void testFaixa1() {
        double resultado = SimuladorImpostoRenda.calcularImposto(2000.00);
        assertEquals(7.20, resultado, 0.01);
    }

    @Test
    public void testFaixa2() {
        double resultado = SimuladorImpostoRenda.calcularImposto(3000.00);
        assertEquals(95.20, resultado, 0.01);
    }

    @Test
    public void testFaixa3() {
        double resultado = SimuladorImpostoRenda.calcularImposto(4000.00);
        assertEquals(263.87, resultado, 0.01);
    }

    @Test
    public void testFaixa4() {
        double resultado = SimuladorImpostoRenda.calcularImposto(7000.00);
        assertEquals(1055.64, resultado, 0.01);
    }

    @Test
    public void testRendaNegativa() {
        double resultado = SimuladorImpostoRenda.calcularImposto(-500.00);
        assertEquals(0.0, resultado, 0.01, "Renda negativa deve retornar zero");
    }
}
