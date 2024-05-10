package MainPackage;

import java.nio.file.Files;
import java.nio.file.Path;

public class MenuInicial {

    public static void main(String[] args) {
        InicialMenu();
    }

    public static void InicialMenu() {

        while (true) {

            System.out.println(
                            "|===============================|\n"+
                            "|                               |\n"+
                            "|    B E M - V I N D O ( A )    |\n"+
                            "|                               |\n"+
                            "|    A Plataforma de Eventos    |\n"+
                            "|        PROJETO BACANA         |\n"+
                            "|                               |\n"+
                            "|===============================|\n"+
                            "|                               |\n"+
                            "|    Escolha umas das opções:   |\n"+
                            "|                               |\n"+
                            "|    1 - Cadastrar-se           |\n"+
                            "|    2 - Login                  |\n"+
                            "|    X - Sair do Programa       |\n"+
                            "|                               |\n"+
                            "|===============================|\n"
            );

            System.out.print("Digite a sua escolha: ");
            var opcao = lerDados.lerTexto("\nPreencha o campo de escolha!: \n").toUpperCase();

            if (opcao.equals("1")) {

                Cadastro_E_Login.CadastrarUser();

            } else if (opcao.equals("2")) {

                Cadastro_E_Login.Login();

            } else if (opcao.equals("X")) {
                return;
            } else {
                System.out.println("Esta não é uma opção válida. Vamos tentar novamente!");
            }

            System.out.println();

        }
    }
}

