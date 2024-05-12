package MainPackage;

public class MenuPrincipal {

    public static void main(String[] args){

        PrincipalMenu();

    }

    public static void PrincipalMenu(){

        while (true) {

            System.out.println(
                            "|==================================|\n"+
                            "|                                  |\n"+
                            "|    Escolha umas das opções:      |\n"+
                            "|                                  |\n"+
                            "|    1 - Cadastrar Novo Evento     |\n"+
                            "|    2 - Listar Eventos            |\n"+
                            "|    3 - Pesquisar Evento          |\n"+
                            "|    4 - Deletar Evento            |\n"+
                            "|    X - Voltar ao Menu Inicial    |\n"+
                            "|                                  |\n"+
                            "|==================================|\n"
            );

            System.out.print("Digite a sua escolha: ");
            var opcao = lerDados.lerTexto("\nPreencha o campo de escolha!").toUpperCase();

            if (opcao.equals("1")) {

                MenuTipos_Evento.MenuTiposEvento();

            } else if (opcao.equals("2")) {

                System.out.println("_________Comicios_________");
                ObjectComicio.listarComicios();
                System.out.println("_________________________\n");
                System.out.println("_________Festas_________");
                ObjectFesta.listarFesta();
                System.out.println("_________________________\n");
                System.out.println("_________Shows_________");
                ObjectShow.listarShow();
                System.out.println("_________________________\n");
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
