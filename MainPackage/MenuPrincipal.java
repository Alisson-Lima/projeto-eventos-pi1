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

                boolean comicioExiste = false;
                boolean festaExiste = false;
                boolean showExiste = false;
                boolean reuniaoExiste = false;

                if(File.arquivoExiste("Comicio.txt")) {
                    System.out.println("_________Comicios_________");
                    ObjectComicio.listarComicio();
                    System.out.println("_________________________\n");

                    comicioExiste = true;
                }
                if(File.arquivoExiste("Festa.txt")) {
                    System.out.println("_________Festas_________");
                    ObjectFesta.listarFesta();
                    System.out.println("_________________________\n");

                    festaExiste = true;
                }
                if(File.arquivoExiste("Show.txt")) {
                    System.out.println("_________Shows_________");
                    ObjectShow.listarShow();
                    System.out.println("_________________________\n");

                    showExiste = true;
                }
                if(File.arquivoExiste("Reuniao.txt")) {
                    System.out.println("_________Reuniões_________");
                    ObjectReuniao.listarReuniao();
                    System.out.println("_________________________\n");

                    reuniaoExiste = true;
                }

                if(comicioExiste == false && festaExiste == false && showExiste == false && reuniaoExiste == false){
                    System.out.println("\nNenhum evento foi cadastrado ainda!");
                }

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
