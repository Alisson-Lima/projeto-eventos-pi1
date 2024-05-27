package MainPackage;

import java.util.ArrayList;
import java.util.List;

import static MainPackage.ListaParticipantes.converterArrayParticipantesEmString;
import static MainPackage.ListaParticipantes.converterStringEmParticipantes;

public class MenuFesta {
        public static void menuFesta(){

            while (true) {

                System.out.println();
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Cadastrar Festa");
                System.out.println("2 - Buscar Festa");
                System.out.println("3 - Listar Festa");
                System.out.println("X - VOLTAR");
                System.out.println();
                System.out.print("Digite a sua escolha: ");

                var escolha = lerDados.lerTexto("Opção Inválida").toUpperCase();
                if (escolha.equals("1")) {
                    cadastrarFesta();
                }else if (escolha.equals("2")) {
                    ObjectFesta.buscarFesta();
                    return;
                }else if (escolha.equals("3")) {
                    ObjectFesta.listarFesta();
                    return;
                } else if (escolha.equals("X")) {
                    return;
                }

            }
        }

        private static void cadastrarFesta() {
            Boolean Disponivel = true;

            System.out.println();
            System.out.println("__________Cadasto da Festa_________\nNome da Festa: ");
            var Nome = lerDados.lerTexto("Opção Inválida\n");

            System.out.println("Data da Festa: ");
            var Data = lerDados.lerData("Opção Inválida - ref(dd-mm-yyyy)\n");

            System.out.println("Horario da Festa: ");
            var Horario = lerDados.lerHorario("Opção Inválida - ref(HH:mm)\n");

            System.out.println("Local da Festa: ");
            var Local = lerDados.lerTexto("Opção Inválida\n");

            System.out.println("Descrição da Festa: ");
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

            System.out.println("Os ingressos estão disponiveis? Sim[S] Não[N]");
            var ingressosDisponiveis = lerDados.lerTexto("Opção Inválida Tente novamente:\n");

            if(ingressosDisponiveis.equals("n")){
                Disponivel = false;
            }

            var cadFesta = new ObjectFesta(Nome, Data, Horario ,Local, Descricao, LinhaParticipantes, Disponivel);

            Txt_Festa.salvar(cadFesta);
            System.out.println("Festa cadastrada");
        }
    }


