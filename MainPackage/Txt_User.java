package MainPackage;

import java.util.List;

public class Txt_User {

    private static final String FILE = "Users.txt";

    public static List<ObjectUser> lerTudo() {
        var listona = File.lerLinhas(FILE);
        return ObjectUser.construirTodos(listona);
    }

    public static void salvarTudo(List<ObjectUser> tudo) {
        var listona = ObjectUser.desconstruirTodos(tudo);
        File.escreverLinhas(listona, FILE);
    }

    public static void salvar(ObjectUser registro) {
        var tudo = lerTudo();
        tudo.add(registro);
        salvarTudo(tudo);
    }

}
