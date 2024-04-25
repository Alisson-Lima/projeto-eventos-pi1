package MainPackage;

import java.util.ArrayList;
import java.util.List;


public class CriarFesta {

    public static class Festa {

        private static int nextID = 1;

        int ID;
        String Nome;
        String Data;
        String Horario;
        String Local;
        String Descricao;
        int Limite_Participantes;
        boolean Disponivel;


        public Festa(String Nome, String Data, String Horario, String Local, String Descricao, int Limite_Participantes, boolean Disponivel) {

            this.ID = nextID++;
            this.Nome = Nome;
            this.Data = Data;
            this.Horario = Horario;
            this.Local = Local;
            this.Descricao = Descricao;
            this.Limite_Participantes = Limite_Participantes;
            this.Disponivel = Disponivel;

        }

    }

    public static List<Festa> addFesta() {

        lerDados ler = new lerDados();
        boolean option = true;

        List<Festa> festas = new ArrayList<>();

        while (option) {

            System.out.println("\nDigite o nome do evento:");
            String nomeFesta = ler.lerTexto("\nPreencha o campo de nome do evento!:\n");

            System.out.println("\nDigite a data do evento:");
            String dataFesta = ler.lerData("\nPreencha o campo de data do evento no formato dd/mm/yyyy!:\n");

            System.out.println("\nDigite o horário do evento:");
            String horarioFesta = ler.lerHorario("\nPreencha o campo de horário do evento no formato HH:mm!:\n");

            System.out.println("\nDigite o local do evento:");
            String localFesta = ler.lerTexto("\nPreencha o campo de local do evento!:\n");

            System.out.println("\nDigite a descrição do evento:");
            String descricaoFesta = ler.lerTexto("\nPreencha o campo de descrição do evento!:\n");

            System.out.println("\nDigite o limite de participantes do evento:");
            int limitParticipantesFesta = ler.lerInt("\nPreencha o campo apenas com números inteiros positivos acima de zero!:\n");

            System.out.println("\nO evento está disponível? (S/N)");
            String disponivelFesta = ler.lerTexto("\nPreencha o campo de disponibilidade do evento com!:\n");

            boolean conversao_Disponivel =  disponivelFesta.toUpperCase().equals("S")  ||
                                            disponivelFesta.toUpperCase().equals("SIM") ? true : false;

            festas.add(new Festa(nomeFesta, dataFesta, horarioFesta, localFesta, descricaoFesta, limitParticipantesFesta, conversao_Disponivel));

            System.out.println("\nDeseja Adicionar outro evento? (S/N)");
            String optionAdicionar_OutroEvento = ler.lerTexto("\nPreencha o campo!:\n");

            option =    optionAdicionar_OutroEvento.toUpperCase().equals("S") ||
                        optionAdicionar_OutroEvento.toUpperCase().equals("SIM") ? true : false;
        }

        System.out.println("\n___________________Eventos Cadastrados___________________");

        for (Festa festa : festas) {

            System.out.println("\nID: " + festa.ID + "\nNome: " + festa.Nome + "\nData: " + festa.Data + "\nLocal: " + festa.Local + "\nDescrição: " +
                    festa.Descricao + "\nLimite de participantes: " + festa.Limite_Participantes + "\nDisponível: " + festa.Disponivel);
        }

        return festas;
    }
}