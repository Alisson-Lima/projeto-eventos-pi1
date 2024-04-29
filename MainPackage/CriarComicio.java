package MainPackage;

import java.util.ArrayList;
import java.util.List;


public class CriarComicio {
    public static class Comicio{
        private static int nextID = 1;

        int id;
        String Nome;
        String Data;
        String Horario;
        String Local;
        String Partido;
        String Descricao;
        Boolean Autorizacao;

        public Comicio(String Nome, String Data, String Horario, String Local, String Partido, String Descricao,Boolean Autorizacao){
            this.id = nextID++;
            this.Nome = Nome;
            this.Data = Data;
            this.Horario = Horario;
            this.Local = Local;
            this.Partido = Partido;
            this.Descricao = Descricao;
            this.Autorizacao = Autorizacao;


        }

    }

    public static List<Comicio> addComicio(){
        lerDados ler = new lerDados();

        boolean select = true;
        List<CriarComicio.Comicio> comicios = new ArrayList<>();

        while(select){
            System.out.println("\nDigite o nome do comício:");
            String nomeComicio = ler.lerTexto("\nPreencha o campo de nome do comício!:\n");

            System.out.println("\nDigite a data do comício:");
            String dataComicio = ler.lerData("\nPreencha o campo de data do comício no formato dd/mm/yyyy!:\n");

            System.out.println("\nDigite o horário do comício:");
            String horarioComicio = ler.lerHorario("\nPreencha o campo de horário do comício no formato HH:mm!:\n");

            System.out.println("\nDigite o local do comício:");
            String localComicio = ler.lerTexto("\nPreencha o campo de local do comício!:\n");

            System.out.println("\nDigite o paritdo do comício:");
            String paritdoComicio = ler.lerTexto("\nPreencha o campo com o partido do comício!:\n");

            System.out.println("\nDigite a descrição do comício:");
            String descricaoComicio = ler.lerTexto("\nPreencha o campo de descrição do comício!:\n");

            System.out.println("\nO comício tem atorização? (S/N)");
            String autorizacaoComicio = ler.lerTexto("\nPreencha o campo de disponibilidade do comício com!:\n");

            boolean conversao_Disponivel =  autorizacaoComicio.toUpperCase().equals("S")  ||
                    autorizacaoComicio.toUpperCase().equals("SIM") ? true : false;

            comicios.add(new CriarComicio.Comicio(nomeComicio, dataComicio, horarioComicio, localComicio,paritdoComicio, descricaoComicio, conversao_Disponivel));

            System.out.println("\nDeseja Adicionar outro comício? (S/N)");
            String optionAdicionar_OutroEvento = ler.lerTexto("\nPreencha o campo!:\n");

            select =    optionAdicionar_OutroEvento.toUpperCase().equals("S") ||
                    optionAdicionar_OutroEvento.toUpperCase().equals("SIM") ? true : false;

            for (Comicio comicio: comicios){
            System.out.println("\nID: " + comicio.id + "\nNome: " + comicio.Nome + "\nData: " + comicio.Data + "\nLocal: " + comicio.Local + "\nPartido: " + comicio.Partido + "\nDescrição: " +
                        comicio.Descricao + "\nAutorização: " + comicio.Autorizacao);
            }

        }return comicios;
    }
}
