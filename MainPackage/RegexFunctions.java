package MainPackage;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexFunctions {

    public static String formatarTelefone(String telefone) {
        // Define o padrão da regex para os dígitos
        String regex = "(\\d{2})(\\d{5})(\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefone);

        String Telefone;

        while (!matcher.matches()) {

            System.out.println("\nO telefone digitado tem menos de 11 digítos incluindo o DD: ");
            Telefone = lerDados.lerTexto("\nPreencha o Campo de Telefone!\n");

            matcher = pattern.matcher(Telefone);

            if (matcher.matches()) {
                return String.format("(%s) %s-%s", matcher.group(1), matcher.group(2), matcher.group(3));
            }

        }


        return String.format("(%s) %s-%s", matcher.group(1), matcher.group(2), matcher.group(3));

    }

    public static String formatarCPF(String cpfOuCnpj) {

        String regex = cpfOuCnpj.length() <= 11 ? "(\\d{3})(\\d{3})(\\d{3})(\\d{2})"
                                                : "(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(cpfOuCnpj);

        String CPFOUCNPJ;

        String cpfOuCnpj_Formatado = "";

        while (!matcher.matches()) {

            System.out.println("\nO CPF ou CNPJ digitado não tem entre 11 ou 14 digitos: ");
            CPFOUCNPJ = lerDados.lerTexto("\nPreencha o Campo de CPF ou CNPJ!\n");

            matcher = pattern.matcher(CPFOUCNPJ);

        }

        if (matcher.matches()) {


            cpfOuCnpj_Formatado =   regex.equals("(\\d{3})(\\d{3})(\\d{3})(\\d{2})")
                                    ?   String.format("%s.%s.%s-%s",
                                        matcher.group(1),
                                        matcher.group(2),
                                        matcher.group(3),
                                        matcher.group(4))

                                    :   String.format("%s.%s.%s/%s-%s",
                                        matcher.group(1),
                                        matcher.group(2),
                                        matcher.group(3),
                                        matcher.group(4),
                                        matcher.group(5));

        }

        return cpfOuCnpj_Formatado;
    }
}


