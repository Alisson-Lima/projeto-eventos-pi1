package MainPackage;

public class MenuShow {
    public static void menuShow(){

        while (true) {

            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Show");
            System.out.println("2 - Buscar Show");
            System.out.println("3 - Listar Show");
            System.out.println("4 - Cadastrar Venda");
            System.out.println("X - VOLTAR");
            System.out.println();
            System.out.print("Digite a sua escolha: ");
            var escolha = lerDados.lerTexto("Opção Inválida").toUpperCase();
            if (escolha.equals("1")) {
                cadastrarShow();
            } else if(escolha.equals("2")) {
                ObjectShow.buscarids();
            }else if(escolha.equals("3")){
                ObjectShow.listarShow();
            }else if(escolha.equals("4")){
                ObjectShow.cadVenda();
            }else if(escolha.equals("X")){
                return;
            }

        }
    }
        private static void cadastrarShow() {
            Boolean ingressosDisponiveis = true;

            boolean fileVerify = File.arquivoExiste("Show.txt");
            String id = "";
            if (fileVerify) {
                int idInt = 1;
                String prefixo = "S";
                String numero;
                boolean verificacao;
                do {
                    numero = prefixo + idInt;
                    verificacao = ObjectShow.verifyId(numero);
                    if (verificacao) {
                        idInt++;
                    }
                } while (verificacao);
                id = numero;
            } else {
                id = "S1";
            }

            var proprietario = Cadastro_E_Login.Retornar_EmailLogado();

            System.out.println();
            System.out.println("__________Cadasto de Show_________\nNome do Show: ");
            var nome = lerDados.lerTexto("Inválido Tente novamente:\n");

            System.out.println("Data do Show: ");
            var data = lerDados.lerData("Data Inválida Tente novamente:\n");

            System.out.println("Horario do Show: ");
            var horario = lerDados.lerHorario("Horario Inválido Tente novamente:\n");

            System.out.println("Local do Show: ");
            var local = lerDados.lerTexto("Local Inválido Tente novamente:\n");

            System.out.println("Descrição do Show: ");
            var descricao = lerDados.lerTexto("Descrição Inválida Tente novamente:\n");

            System.out.println("Limites de ingressos do Show: ");
            var limiteIngressos = lerDados.lerInt("Valor Inválido Tente novamente:\n");

            System.out.println("Os ingressos estão disponiveis? Sim[S] Não[N]");
            var ingressos = lerDados.lerTexto("Opção Inválida Tente novamente:\n");

            if(ingressos.equals("n")){
               ingressosDisponiveis = false;
            }
            System.out.println("Digite o valor do ingresso em R$: ");
            var precodoingresso = lerDados.lerDouble("Valor incorreto, tente algo como R$ 2.00");

            var showcad = new ObjectShow(id, proprietario, nome, data, horario, local, descricao, limiteIngressos, ingressosDisponiveis,precodoingresso);
            Txt_Show.salvar(showcad);
            System.out.println("ID " + id);
            System.out.println("Nome: " + nome);
            System.out.println("Data: " + data);
            System.out.println("Horario: " + horario);
            System.out.println("Local: " + local);
            System.out.println("Descrição: " + descricao);
            System.out.println("Limite de Ingressos: " + limiteIngressos);
            System.out.println("Ingressos Disponiveis: " + ingressosDisponiveis);
            System.out.println("Valor do ingresso: R$"+ precodoingresso);
            System.out.println("******* Show cadastrado *******");
        }

}
