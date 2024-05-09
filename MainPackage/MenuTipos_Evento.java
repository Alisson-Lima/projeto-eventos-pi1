package MainPackage;

public class MenuTipos_Evento {

    public static void main(String[] args) {

        MenuTiposEvento();

    }

    public static void MenuTiposEvento(){

        while (true) {

            System.out.println(
                            "\n|==================================|\n"+
                            "|                                  |\n"+
                            "|    Escolha umas das opções:      |\n"+
                            "|                                  |\n"+
                            "|    1 - Comício                   |\n"+
                            "|    2 - Festa                     |\n"+
                            "|    3 - Reunião                   |\n"+
                            "|    4 - Show                      |\n"+
                            "|    X - Voltar ao Menu Principal  |\n"+
                            "|                                  |\n"+
                            "|==================================|\n"
            );

            System.out.print("Digite a sua escolha: ");
            var opcao = lerDados.lerTexto("\nPreencha o campo de escolha!: \n").toUpperCase();

            if (opcao.equals("1")) {

            } else if (opcao.equals("2")) {

            } else if (opcao.equals("3")) {

            } else if (opcao.equals("4")) {
                MenuShow.menuShow();
            } else if (opcao.equals("X")) {
                return;
            } else {
                System.out.println("Esta não é uma opção válida. Vamos tentar novamente!");
            }

            System.out.println();

        }
    }

}
