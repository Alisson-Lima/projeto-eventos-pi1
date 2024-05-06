package MainPackage;

public class MenuPrincipal {

    public static void main(String[] args){

        PrincipalMenu();
    }

    public static void PrincipalMenu(){

        while (true) {

            System.out.println(
                    "|===============================|\n"+
                            "|                               |\n"+
                            "|    Escolha umas das opções:   |\n"+
                            "|                               |\n"+
                            "|    1 - Criar Festa            |\n"+
                            "|    2 - Criar Show             |\n"+
                            "|    3 - Criar Comicio          |\n"+
                            "|    4 - Criar Reunião          |\n"+
                            "|    X - voltar                 |\n"+
                            "|                               |\n"+
                            "|===============================|\n"
            );

            System.out.print("\nDigite a sua escolha: ");
            var opcao = lerDados.lerTexto("\nPreencha o campo de escolha!").toUpperCase();

            if (opcao.equals("1")) {

            } else if (opcao.equals("2")) {

            } else if (opcao.equals("3")) {

            } else if (opcao.equals("4")) {

            } else if (opcao.equals("X")) {
                return;
            } else {
                System.out.println("Esta não é uma opção válida. Vamos tentar novamente!");
            }

            System.out.println();

        }
    }

}
