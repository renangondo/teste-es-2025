package br.edu.ifpr.teste.servico.calendario;

import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TesteCalendario {

    @Test
    public void testGetCalendarioSemParametros() {
        String calendario = CalendarioUtils.getCalendario();
        YearMonth atual = YearMonth.now();
        String nomeMes = atual.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());

        assertTrue(calendario.contains(nomeMes), "Deve conter o mês atual");
        assertTrue(calendario.contains(String.valueOf(atual.getYear())), "Deve conter o ano atual");
    }

    @Test
    public void testGetCalendarioComAnoValido() {
        String calendario = CalendarioUtils.getCalendario("2023");
        assertTrue(calendario.contains("Janeiro 2023"), "Deve conter Janeiro de 2023");
        assertTrue(calendario.contains("Dezembro 2023"), "Deve conter Dezembro de 2023");
    }

    @Test
    public void testGetCalendarioComMesEAnoValidos() {
        String calendario = CalendarioUtils.getCalendario("2", "2024");
        assertTrue(calendario.contains("Fevereiro 2024"), "Deve conter Fevereiro de 2024");
    }

    @Test
    public void testGetCalendarioComParametrosExcedentes() {
        String calendario = CalendarioUtils.getCalendario("3", "2020", "extra", "param");
        assertTrue(calendario.contains("Março 2020"), "Deve conter Março de 2020");
        assertFalse(calendario.contains("extra"), "Não deve conter parâmetros excedentes");
    }

    @Test
    public void testGetCalendarioReformaGregoriana() {
        String calendario = CalendarioUtils.getCalendario("9", "1752");
        // Testa se há quebra de sequência entre os dias 2 e 14
        assertTrue(calendario.contains("2"), "Deve conter o dia 2 de setembro de 1752");
        assertTrue(calendario.contains("14"), "Deve conter o dia 14 de setembro de 1752");
        assertFalse(calendario.contains("3"), "Não deve conter o dia 3 de setembro de 1752");
    }

    @Test
    public void testGetCalendarioAnoLimiteInferior() {
        String calendario = CalendarioUtils.getCalendario("1");
        assertTrue(calendario.contains("Janeiro 1"), "Deve conter Janeiro do ano 1");
    }

    @Test
    public void testGetCalendarioAnoLimiteSuperior() {
        String calendario = CalendarioUtils.getCalendario("9999");
        assertTrue(calendario.contains("Janeiro 9999"), "Deve conter Janeiro de 9999");
    }

    @Test
    public void testGetCalendarioMesInvalido() {
        String calendario = CalendarioUtils.getCalendario("13", "2023");
        assertTrue(calendario.isEmpty() || calendario.contains("Erro"), "Deve retornar vazio ou mensagem de erro");
    }

    @Test
    public void testGetCalendarioAnoInvalido() {
        String calendario = CalendarioUtils.getCalendario("0");
        assertTrue(calendario.isEmpty() || calendario.contains("Erro"), "Ano 0 não é permitido");
    }

    // Teste Calendario do Exercicio 06 
    
    @Test
    public void testGetCalendarioAnoNegativo() {
        String calendario = CalendarioUtils.getCalendario("-44");
        assertTrue(calendario.isEmpty() || calendario.contains("Erro"), "Ano negativo não é permitido");
    }

    @Test
    public void testGetCalendarioComParametroNaoNumerico() {
        String calendario = CalendarioUtils.getCalendario("abcd");
        assertTrue(calendario.isEmpty() || calendario.contains("Erro"), "Parâmetro não numérico deve ser tratado como inválido");
    }

    @Test
    public void testGetCalendarioComMesZero() {
        String calendario = CalendarioUtils.getCalendario("0", "2023");
        assertTrue(calendario.isEmpty() || calendario.contains("Erro"), "Mês zero não é válido");
    }

    @Test
    public void testGetCalendarioComAnoAcimaDoLimite() {
        String calendario = CalendarioUtils.getCalendario("10000");
        assertTrue(calendario.isEmpty() || calendario.contains("Erro"), "Ano acima de 9999 não é permitido");
    }

    @Test
    public void testGetCalendarioComMesAcimaDoLimite() {
        String calendario = CalendarioUtils.getCalendario("15", "2023");
        assertTrue(calendario.isEmpty() || calendario.contains("Erro"), "Mês acima de 12 não é válido");
    }

}
