package br.edu.ifpr.teste.servico.calendario;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarioUtils {

    public static String getCalendario() {
        LocalDate hoje = LocalDate.now();
        return gerarCalendarioMes(hoje.getMonthValue(), hoje.getYear());
    }

    public static String getCalendario(String ano) {
        try {
            int anoInt = Integer.parseInt(ano);
            if (anoInt < 1 || anoInt > 9999) return "Erro: ano inválido.";

            StringBuilder sb = new StringBuilder();
            for (int mes = 1; mes <= 12; mes++) {
                sb.append(gerarCalendarioMes(mes, anoInt)).append("\n\n");
            }
            return sb.toString().trim();
        } catch (NumberFormatException e) {
            return "Erro: entrada inválida.";
        }
    }

    public static String getCalendario(String mes, String ano) {
        try {
            int mesInt = Integer.parseInt(mes);
            int anoInt = Integer.parseInt(ano);

            if (mesInt < 1 || mesInt > 12) return "Erro: mês inválido.";
            if (anoInt < 1 || anoInt > 9999) return "Erro: ano inválido.";

            return gerarCalendarioMes(mesInt, anoInt);
        } catch (NumberFormatException e) {
            return "Erro: entrada inválida.";
        }
    }

    public static String getCalendario(String... variosParametros) {
        if (variosParametros == null || variosParametros.length == 0) {
            return getCalendario();
        } else if (variosParametros.length == 1) {
            return getCalendario(variosParametros[0]);
        } else {
            return getCalendario(variosParametros[0], variosParametros[1]);
        }
    }

    private static String gerarCalendarioMes(int mes, int ano) {
        if (ano == 1752 && mes == 9) {
            return "Setembro 1752\nDom Seg Ter Qua Qui Sex Sab\n       1   2  14  15  16\n17  18  19  20  21  22  23\n24  25  26  27  28  29  30";
        }

        String nomeMes = java.time.Month.of(mes).getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
        YearMonth ym = YearMonth.of(ano, mes);

        StringBuilder sb = new StringBuilder();
        sb.append(nomeMes).append(" ").append(ano).append("\n");
        sb.append("Dom Seg Ter Qua Qui Sex Sab\n");

        LocalDate primeiroDia = ym.atDay(1);
        int diaSemana = primeiroDia.getDayOfWeek().getValue() % 7;

        for (int i = 0; i < diaSemana; i++) {
            sb.append("    ");
        }

        for (int dia = 1; dia <= ym.lengthOfMonth(); dia++) {
            sb.append(String.format("%3d ", dia));
            diaSemana++;
            if (diaSemana % 7 == 0) sb.append("\n");
        }

        return sb.toString().trim();
    }
} 
