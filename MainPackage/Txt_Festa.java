package MainPackage;

import java.util.List;

public class Txt_Festa {

    private static final String FILE = "Festa.txt";

    public static List<ObjectFesta> lerTudo() {
        var listona = File.lerLinhas(FILE);
        return ObjectFesta.construirTodos(listona);
    }

    public static void salvarTudo(List<ObjectFesta> tudo) {
        var listona = ObjectFesta.desconstruirTodos(tudo);
        File.escreverLinhas(listona, FILE);
    }

//    public static boolean deletar(String placaProcurada) {
//        var tudo = lerTudo();
//        var deletou = tudo.removeIf(v -> v.placa().equalsIgnoreCase(placaProcurada));
//        salvarTudo(tudo);
//        return deletou;
//    }

    public static void salvar(ObjectFesta registro) {
        var tudo = lerTudo();
        tudo.add(registro);
        salvarTudo(tudo);
    }

}
