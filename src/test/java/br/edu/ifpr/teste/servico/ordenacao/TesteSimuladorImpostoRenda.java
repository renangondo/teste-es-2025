package br.edu.ifpr.teste.servico.ordenacao;

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
}
