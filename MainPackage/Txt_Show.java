package MainPackage;

import java.util.List;

public class Txt_Show {
    private static final String FILE = "Show.txt";

    public static List<ObjectShow> lerTudo() {
        var listona = File.lerLinhas(FILE);
        return ObjectShow.construirTodos(listona);
    }

    public static void salvarTudo(List<ObjectShow> tudo) {
        var listona = ObjectShow.desconstruirTodos(tudo);
        File.escreverLinhas(listona, FILE);
    }

    public static void salvar(ObjectShow registro){
        var tudo = lerTudo();
        tudo.add(registro);
        salvarTudo(tudo);
    }
}
