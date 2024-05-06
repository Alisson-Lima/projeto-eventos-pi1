package MainPackage;

import java.util.Scanner;
import java.text.SimpleDateFormat;

public class lerDados {

    private static final Scanner scan = new Scanner(System.in);
    public static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat formatoHorario = new SimpleDateFormat("HH:mm");

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
                    throw new NumberFormatException();
                }

                return linha;
            } catch (NumberFormatException erro) {
                System.out.print(tenteNovamente);
            }
        }
    }

    public static String lerData(String tenteNovamente) {

        while (true) {

            var linha = scan.nextLine();

            try {

                formatoData.parse(linha);

                return linha;
            } catch (java.text.ParseException erro) {
                System.out.print(tenteNovamente);
            }
        }
    }

    public static String lerHorario(String tenteNovamente) {

        while (true) {

            var linha = scan.nextLine();

            try {

                formatoHorario.parse(linha);

                return linha;
            } catch (java.text.ParseException erro) {
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
