package MainPackage;

import java.util.List;

public class Txt_Reuniao {
    private static final String FILE = "Reuniao.txt";

    public static List<ObjectReuniao> lerTudo() {
        var listona = File.lerLinhas(FILE);
        return ObjectReuniao.construirTodos(listona);
    }

    public static void salvarTudo(List<ObjectReuniao> tudo) {
        var listona = ObjectReuniao.desconstruirTodos(tudo);
        File.escreverLinhas(listona, FILE);
    }

    public static void salvar(ObjectReuniao registro){
        var tudo = lerTudo();
        tudo.add(registro);
        salvarTudo(tudo);
    }
}
