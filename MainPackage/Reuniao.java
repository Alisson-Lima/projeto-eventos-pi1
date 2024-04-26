package MainPackage;

import java.util.List;
import java.util.ArrayList;

public class Reuniao {

    public static void LogReuniao() {
        lerDados ler = new lerDados();
        int limiteDeConvidados = 0;
        String nomeDoConvidado;
        List<String> listaDeConvidados = new ArrayList<>(limiteDeConvidados);

        System.out.println("======= Cadastrando reunião =======");

        System.out.println("Dê um nome a sua reunião:");
        String nomeDaReuniao = ler.lerTexto("Nome inválido, tente novamente:");

        System.out.println("De uma descrição para a sua reunião:");
        String descricaoDaReuniao = ler.lerTexto("Descrição inválida, tente novamente:");

        System.out.println("Qual a data da sua reunião? (DD/MM/AAAA):");
        String dataDaReuniao = ler.lerTexto("Data inválida, digite na forma indicada: DD/MM/AAAA:");

        System.out.println("Qual a hora de sua reunião? (HH:MM):");
        String horaDaReuniao = ler.lerTexto("Hora inválida, digite na forma indicada: HH:MM");

        System.out.println("Qual o local da sua reunião? :");
        String localDaReuniao = ler.lerTexto("Local inválido, tente novamente:");

        System.out.println("Qual o limite de convidados? :");
        limiteDeConvidados = ler.lerInt("Limite de pessoas inválido, tente novamente:");

        System.out.println("Quem vai participar de sua reunião? :");
        for (var i = 0; i < limiteDeConvidados; i++){
            System.out.print("Convidado nº" + (i + 1) + ": ");
            nomeDoConvidado = ler.lerTexto("Digite um nome válido:");
            listaDeConvidados.add(nomeDoConvidado);
        }

        NovaReuniao novaReuniao = new NovaReuniao(nomeDaReuniao, descricaoDaReuniao, dataDaReuniao, horaDaReuniao, localDaReuniao, limiteDeConvidados, listaDeConvidados.toArray(new String[0]));

        System.out.println("======= Detalhes da reunião =======");
        System.out.println("Nome: " + novaReuniao.nome());
        System.out.println("Descrição: " + novaReuniao.descricao());
        System.out.println("Data: " + novaReuniao.data());
        System.out.println("Hora: " + novaReuniao.hora());
        System.out.println("Local: " + novaReuniao.local());
        System.out.println("Limite de convidados: " + novaReuniao.limiteConvidados());
        System.out.println("Convidados:");
        for (String convidado : novaReuniao.convidados()) {
            System.out.println("- " + convidado);
        }

    }

    public record NovaReuniao(
            String nome,
            String descricao,
            String data,
            String hora,
            String local,
            int limiteConvidados,
            String[] convidados
    ){}
}
