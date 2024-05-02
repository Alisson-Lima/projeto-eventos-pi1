package MainPackage;

import java.util.List;

public class TxtLogado {

    private static final String FILE = "Logado.txt";

    public static List<String> lerTudo() {
        var listona = File.lerLinhas(FILE);
        return listona;
    }

    public static void salvarTudo(List<String> tudo) {
        var listona = tudo;
        File.escreverLinhas(listona, FILE);
    }


}
