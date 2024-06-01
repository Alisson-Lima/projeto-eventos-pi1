package MainPackage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Optional;
import  java.util.List;
import java.util.ArrayList;

public record ObjectReuniao(

        String Id,
        String Proprietario,
        String Nome,
        LocalDate Data,
        LocalTime Horario,
        String Local,
        String Descricao,
        String participantes,
        boolean Disponivel

) {

    private static final int CAMPOS = ObjectReuniao.class.getRecordComponents().length;

    private static final DateTimeFormatter DATA = DateTimeFormatter
            .ofPattern("dd/MM/uuuu")
            .withChronology(IsoChronology.INSTANCE)
            .withResolverStyle(ResolverStyle.STRICT);

    private static final DateTimeFormatter HORA = DateTimeFormatter
            .ofPattern("HH:mm")
            .withChronology(IsoChronology.INSTANCE)
            .withResolverStyle(ResolverStyle.STRICT);


    public String dataString() {
        return DATA.format(Data);
    }

    public String horarioString() {
        return HORA.format(Horario);
    }

    public List<String> desconstruir() {

        return List.of(Id, Proprietario, Nome, dataString(), horarioString(), Local, Descricao, "" + participantes, "" + Disponivel);
    }


    public static List<String> desconstruirTodos(List<ObjectReuniao> todos) {

        var listona = new ArrayList<String>(todos.size() * CAMPOS);

        for (var r : todos) {
            listona.addAll(r.desconstruir());
        }

        return listona;
    }


    public static ObjectReuniao construir(List<String> listinha) {

        if (listinha.size() != CAMPOS) throw new IllegalArgumentException();
        return new ObjectReuniao(
                listinha.get(0),
                listinha.get(1),
                listinha.get(2),
                LocalDate.parse(listinha.get(3), DATA),
                LocalTime.parse(listinha.get(4), HORA),
                listinha.get(5),
                listinha.get(6),
                listinha.get(7),
                Boolean.parseBoolean(listinha.get(8))
        );
    }

    public static List<ObjectReuniao> construirTodos (List<String> listona) {

        if (listona.size() % CAMPOS != 0) throw new IllegalArgumentException();

        var resultado = new ArrayList<ObjectReuniao>(listona.size() / CAMPOS);

        for (int i = 0; i < listona.size(); i += CAMPOS) {

            var listinha = listona.subList(i, i + CAMPOS);
            var elemento = construir(listinha);
            resultado.add(elemento);
        }

        return resultado;
    }
    public static Optional<ObjectReuniao> buscarNome(List<ObjectReuniao> tudo, String nomeProcurado) {
        return tudo.stream().filter(r -> r.Nome().equals(nomeProcurado)).findAny();
    }

    public static Optional<ObjectReuniao> buscarId(List<ObjectReuniao> tudo, String idProcurado) {
        return tudo.stream().filter(r -> r.Id().equals(idProcurado)).findAny();
    }
    public static Optional<ObjectReuniao> buscarhorario(List<ObjectReuniao> tudo, String horarioprocurado) {
        return tudo.stream().filter(r -> r.Horario().equals(horarioprocurado)).findAny();
    }
    public static Optional<ObjectReuniao> buscarData(List<ObjectReuniao> tudo, String dataProcurada) {
        return tudo.stream().filter(r -> r.Data().equals(dataProcurada)).findAny();
    }


    public static void buscarReuniao() {
        System.out.println();
        System.out.print("Digite o nome da Reunião: ");
        var nomesReunioes = lerDados.lerTexto("Inválido");
        var reuniao = Txt_Reuniao.lerTudo();
        var encontrou = ObjectReuniao.buscarNome(reuniao, nomesReunioes);
        if (encontrou.isEmpty()) {
            System.out.println("Não encontrei essa Reunião.");
        } else {
            mostrarReuniao(encontrou.get());
        }
    }
    public static boolean verifyId(String idReuniao) {

        var reuniao = Txt_Reuniao.lerTudo();
        var encontrou = ObjectReuniao.buscarId(reuniao, idReuniao);
        return encontrou.isPresent();
    }
    private static void mostrarReuniao(ObjectReuniao r) {
        System.out.println("ID " + r.Id());
        System.out.println("Nome: " + r.Nome());
        System.out.println("Data: " + r.dataString());
        System.out.println("Horario: " + r.Horario());
        System.out.println("Local: " + r.Local());
        System.out.println("Descrição: " + r.Descricao());
        System.out.println("Participantes:");
        var arrPart = ListaParticipantes.converterStringEmParticipantes(r.participantes);
        for(var nome: arrPart){
            System.out.println("    • " + nome);
        }
    }
    private static void mostrarReuniaos(ObjectReuniao r) {
        System.out.println("ID " + r.Id());
        System.out.println("ID ");
        System.out.println("Nome: " + r.Nome());
        System.out.println("Data: " + r.dataString());
        System.out.println("Horario: " + r.Horario());
        System.out.println("Local: " + r.Local());
        System.out.println("Descrição: " + r.Descricao());
        System.out.println("Participantes:");
        System.out.println(mostrarLista(r));
        System.out.println("Ingressos Disponiveis: " + r.Disponivel());
    }

    private static String mostrarProprietario(ObjectReuniao r) {

        return r.Proprietario();
    }
   /* public static void listarReuniao() {
        var reuniao = Txt_Reuniao.lerTudo();
        for (var r : reuniao) {
            System.out.println();
            mostrarReuniao(r);
        }
    }
*/


private static String mostrarLista(ObjectReuniao r) {
    var nomes = "";
    var arrPart = ListaParticipantes.converterStringEmParticipantes(r.participantes);
    for(var nome: arrPart){

        nomes += "    • " + nome + "\n";
    }
    return nomes;
}
   public static void listarReuniao() {
       var reuniao = Txt_Reuniao.lerTudo();
       var email = Cadastro_E_Login.Retornar_EmailLogado();
       for (var r : reuniao) {
           var emailtxt = mostrarProprietario(r);
           if (email.equals(emailtxt)){
               System.out.println();
               mostrarReuniaos(r);
           }
       }
   }


}