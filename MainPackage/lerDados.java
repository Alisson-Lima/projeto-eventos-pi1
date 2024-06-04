package MainPackage;

import java.time.DateTimeException;
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

    private static final LocalDate dataAtual = LocalDate.now();


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

    public static LocalDate lerDataUser(String tenteNovamente) {
        while (true) {
            var linha = scan.nextLine();
            try {

                var dateInput = LocalDate.parse(linha, DATA);

                LocalDate compareDateNow =  LocalDate.of(
                                            dataAtual.getYear(),
                                            dataAtual.getMonthValue(),
                                            dataAtual.getDayOfMonth()
                );

                LocalDate compareDateInput = LocalDate.of(
                                             dateInput.getYear(),
                                             dateInput.getMonthValue(),
                                             dateInput.getDayOfMonth()
                );

                LocalDate compareDateMin = LocalDate.of(
                                      1900,
                                     1,
                                 1
                );

                if (compareDateInput.isAfter(compareDateNow) || compareDateInput.isBefore(compareDateMin)){
                    throw new DateTimeException("Data inválida");
                }

                if(dataAtual.getYear() - dateInput.getYear() < 18){
                    throw new DateTimeException("Menor de Idade");
                }

                return dateInput;

            } catch (DateTimeException erro){
                 if (erro.getMessage().equals("Data inválida")) {
                    System.out.println("\nAcredito que não seja possível nascer amanhã ou há 125 anos atrás. ");
                } else if (erro.getMessage().equals("Menor de Idade")){
                    System.out.print("\nSó possível efetuar o cadastro sendo maior de idade. \n");
                }
            } System.out.print(tenteNovamente);
        }
    }

    public static LocalDate lerData(String tenteNovamente) {
        while (true) {
            var linha = scan.nextLine();
            try {

                var dateInput = LocalDate.parse(linha, DATA);

                LocalDate compareDateNow =  LocalDate.of(
                        dataAtual.getYear(),
                        dataAtual.getMonthValue(),
                        dataAtual.getDayOfMonth()
                );

                LocalDate compareDateInput = LocalDate.of(
                        dateInput.getYear(),
                        dateInput.getMonthValue(),
                        dateInput.getDayOfMonth()
                );

                LocalDate compareDateMin = LocalDate.of(
                        1900,
                        1,
                        1
                );

                if (compareDateInput.isBefore(compareDateNow)){
                    throw new DateTimeException("Data inválida");
                }

                return dateInput;

            } catch (DateTimeException erro){
                if (erro.getMessage().equals("Data inválida")) {
                    System.out.println("\nAcredito que não seja possível criar um evento com a data anterior a hoje.\n");
                }

            } System.out.print(tenteNovamente);
        }
    }

    public static LocalTime lerHorario(String tenteNovamente) {
        while (true) {
            var linha = scan.nextLine();
            try {

                return LocalTime.parse(linha, HORA);
            } catch (DateTimeParseException erro) {
                System.out.print(tenteNovamente);
            }

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
