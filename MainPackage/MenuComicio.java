package MainPackage;

public class MenuComicio {
    public static void menuComicio(){

        while (true) {

            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar comicio");
            System.out.println("2 - Buscar comicio");
            System.out.println("3 - Listar comicio");
            System.out.println("X - VOLTAR");
            System.out.println();
            System.out.print("Digite a sua escolha: ");
            var escolha = lerDados.lerTexto("Opção Inválida").toUpperCase();
            if (escolha.equals("1")) {
                cadastrarComicio();
            }else if (escolha.equals("2")) {
                ObjectComicio.buscarComicio();
                return;
            }else if (escolha.equals("3")) {
                ObjectComicio.listarComicios();
                return;
            } else if (escolha.equals("X")) {
                return;
            }

        }
    }

        private static void cadastrarComicio() {

            System.out.println();
            System.out.println("__________Cadasto de Comicio_________\nNome do Comicio: ");
            var nome = lerDados.lerTexto("Opção Inválida\n");

            System.out.println("Data do Comicio: ");
            var data = lerDados.lerData("Opção Inválida - ref(dd-mm-yyyy)\n");

            System.out.println("Horario do Comicio: ");
            var horario = lerDados.lerHorario("Opção Inválida - ref(HH:mm)\n");

            System.out.println("Local do Comicio: ");
            var local = lerDados.lerTexto("Opção Inválida\n");

            System.out.println("Partido do Comicio: ");
            var partido = lerDados.lerTexto("Opção Inválida\n");

            System.out.println("Descrição do Comicio: ");
            var descricao = lerDados.lerTexto("Opção Inválida\n");

            System.out.println("Possui Altorização? Sim[S] Não[N]");
            var autorizacao = lerDados.lerSimNao("Opção Inválida\n");
            if(!autorizacao){
                System.out.println("Procure uma autorização para o seu comicio!");
            }

            var cadcomicio = new ObjectComicio(nome, data, horario ,local, partido, descricao, autorizacao);
            Txt_Comicio.salvar(cadcomicio);
            System.out.println("Comicio cadastrado");
        }
    }
