package MainPackage;

import java.util.ArrayList;

import static MainPackage.ListaParticipantes.converterArrayParticipantesEmString;

public class MenuReuniao {

    public static void menuReuniao(){

        while (true) {

            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Reunião");
            System.out.println("2 - Buscar Reunião");
            System.out.println("3 - Listar Reuniões");
            System.out.println("X - VOLTAR");
            System.out.println();
            System.out.print("Digite a sua escolha: ");

            var escolha = lerDados.lerTexto("Opção Inválida").toUpperCase();
            if (escolha.equals("1")) {
                cadastrarReuniao();
            }else if (escolha.equals("2")) {
                ObjectReuniao.buscarReuniao();
                return;
            }else if (escolha.equals("3")) {
                ObjectReuniao.listarReuniao();
                return;
            } else if (escolha.equals("X")) {
                return;
            }

        }

    }

    private static void cadastrarReuniao() {
        Boolean Disponivel = true;

        System.out.println();
        System.out.println("__________Cadasto da Reunião_________\nNome da Reunião: ");
        var Nome = lerDados.lerTexto("Opção Inválida\n");

        System.out.println("Data da Reunião: ");
        var Data = lerDados.lerData("Opção Inválida - ref(dd-mm-yyyy)\n");

        System.out.println("Horário da Reunião: ");
        var Horario = lerDados.lerHorario("Opção Inválida - ref(HH:mm)\n");

        System.out.println("Local da Reunião: ");
        var Local = lerDados.lerTexto("Opção Inválida\n");

        System.out.println("Descrição da Reunião: ");
        var Descricao = lerDados.lerTexto("Opção Inválida\n");

        var Participantes = new ArrayList<String>();
        Boolean continuar = true;

        while(continuar){

            System.out.println("Digite o nome do participante: ");
            var nome = lerDados.lerTexto("Valor Inválido Tente novamente:\n");
            Participantes.add(nome);

            System.out.println("Adicionar mais um participante? [Sim/Não] ");
            Boolean res = lerDados.lerSimNao("Preencha o campo de nome de participantes");

            if(!res){
                continuar = false;
            }

        }

        String LinhaParticipantes = converterArrayParticipantesEmString(Participantes);

        var cadReuniao = new ObjectReuniao(Nome, Data, Horario ,Local, Descricao, LinhaParticipantes, Disponivel);

        Txt_Reuniao.salvar(cadReuniao);
        System.out.println("******* Reunião cadastrada *******");
    }

}
