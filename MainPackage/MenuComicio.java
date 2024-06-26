package MainPackage;

import java.io.BufferedReader;
import java.io.IOException;

public class MenuComicio {
    public static void menuComicio(){

        while (true) {

            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar comício");
            System.out.println("2 - Buscar comício");
            System.out.println("3 - Listar comício");
            System.out.println("X - VOLTAR");
            System.out.println();
            System.out.print("Digite a sua escolha: ");
            var escolha = lerDados.lerTexto("Opção Inválida").toUpperCase();
            if (escolha.equals("1")) {
                cadastrarComicio();
            }else if (escolha.equals("2")) {
                ObjectComicio.buscarids();
            }else if (escolha.equals("3")) {
                ObjectComicio.listarComicio();
            } else if (escolha.equals("X")) {
                return;
            }

        }
    }

    private static void cadastrarComicio() {
        boolean fileVerify = File.arquivoExiste("Comicio.txt");
        String id = "";
        if (fileVerify) {
            int idInt = 1;
            String prefixo = "C";
            String numero;
            boolean verificacao;
            do {
                numero = prefixo + idInt;
                verificacao = ObjectComicio.verifyId(numero);
                if (verificacao) {
                    idInt++;
                }
            } while (verificacao);
            id = numero;
        } else {
            id = "C1";
        }

        var proprietario = Cadastro_E_Login.Retornar_EmailLogado();

        System.out.println();
        System.out.println("__________Cadasto de Comício_________\nNome do Comício: ");


        var nome = lerDados.lerTexto("Opção Inválida\n");

        System.out.println("Data do Comício: ");
        var data = lerDados.lerData("Opção Inválida - ref(dd/mm/yyyy)\n");

        System.out.println("Horario do Comício: ");
        var horario = lerDados.lerHorario("Opção Inválida - ref(HH:mm)\n");

        System.out.println("Local do Comício: ");
        var local = lerDados.lerTexto("Opção Inválida\n");

        System.out.println("Partido do Comício: ");
        var partido = lerDados.lerTexto("Opção Inválida\n");

        System.out.println("Descrição do Comício: ");
        var descricao = lerDados.lerTexto("Opção Inválida\n");

        System.out.println("Possui Altorização? Sim[S] Não[N]");
        var autorizacao = lerDados.lerSimNao("Opção Inválida\n");
        if(!autorizacao){
            System.out.println("Procure uma autorização para o seu comício!");
        }

        var cadcomicio = new ObjectComicio(id, proprietario, nome, data, horario ,local, partido, descricao, autorizacao);
        Txt_Comicio.salvar(cadcomicio);
        System.out.println("ID " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Horario: " + horario);
        System.out.println("Local: " + local);
        System.out.println("Partido: " + partido);
        System.out.println("Descrição: " + descricao);
        System.out.println("Autorização: " + autorizacao);
        System.out.println("******* Comício cadastrado *******");
    }
}
