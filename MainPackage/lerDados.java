package MainPackage;

import java.time.LocalTime;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class lerDados {

    private static final Scanner scan = new Scanner(System.in);
    private static final DateTimeFormatter DATA = DateTimeFormatter
            .ofPattern("dd/MM/uuuu")
            .withChronology(IsoChronology.INSTANCE)
            .withResolverStyle(ResolverStyle.STRICT);

    private static final DateTimeFormatter HORA = DateTimeFormatter
            .ofPattern("HH:mm")
            .withChronology(IsoChronology.INSTANCE)
            .withResolverStyle(ResolverStyle.STRICT);

    public static int lerInt(String tenteNovamente) {
        while (true) {
            var linha = scan.nextLine();
            try {
                int conversao = Integer.parseInt(linha);

                if(conversao <= 0) {
                    throw new NumberFormatException();
                }
                return conversao;
            } catch (NumberFormatException erro) {
                System.out.print(tenteNovamente);
            }
        }
    }

    public static double lerDouble(String tenteNovamente) {
        while (true) {
            var linha = scan.nextLine();
            try {
                return Double.parseDouble(linha);
            } catch (NumberFormatException erro) {
                System.out.print(tenteNovamente);
            }
        }
    }

    public static String lerTexto(String tenteNovamente) {

        while (true) {

            var linha = scan.nextLine();

            try {

                if(linha.isEmpty()) {
                    throw new Exception();
                }

                return linha;
            } catch (Exception erro) {
                System.out.print(tenteNovamente);
            }
        }
    }

    public static LocalDate lerData(String tenteNovamente) {
        while (true) {
            var linha = scan.nextLine();
            try {

                if(linha.isEmpty()) {
                    throw new Exception();
                }

                return LocalDate.parse(linha, DATA);
            } catch (Exception erro) {
                System.out.print(tenteNovamente);
            }
        }
    }

    public static LocalTime lerHorario(String tenteNovamente) {
        while (true) {
            var linha = scan.nextLine();
            try {
                return LocalTime.parse(linha, HORA);
            } catch (DateTimeParseException erro) {
                // Ignora o erro, segue com o System.out.println mais abaixo e com o while true em seguida.
            }
            System.out.print(tenteNovamente);
        }
    }

    public static boolean lerSimNao(String tenteNovamente) {
        while (true) {
            var linha = lerTexto("").toUpperCase();
            if (linha.equals("S") || linha.equals("SIM")) return true;
            if (linha.equals("N") || linha.equals("NAO") || linha.equals("NÃO")) return false;
            System.out.print(tenteNovamente);
        }
    }
}
