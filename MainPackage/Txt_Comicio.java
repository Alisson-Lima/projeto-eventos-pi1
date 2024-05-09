package MainPackage;

import java.util.List;
public class Txt_Comicio {
    private static final String FILE = "Comicio.txt";

    public static List<ObjectComicio> lerTudo() {
        var listona = File.lerLinhas(FILE);
        return ObjectComicio.construirTodos(listona);
    }

    public static void salvarTudo(List<ObjectComicio> tudo) {
        var listona = ObjectComicio.desconstruirTodos(tudo);
        File.escreverLinhas(listona, FILE);
    }

//    public static boolean deletar(String placaProcurada) {
//        var tudo = lerTudo();
//        var deletou = tudo.removeIf(v -> v.placa().equalsIgnoreCase(placaProcurada));
//        salvarTudo(tudo);
//        return deletou;
//    }

    public static void salvar(ObjectComicio registro) {
        var tudo = lerTudo();
        tudo.add(registro);
        salvarTudo(tudo);
    }
}