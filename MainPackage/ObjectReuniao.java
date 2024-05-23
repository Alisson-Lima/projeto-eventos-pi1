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

        String Nome,
        LocalDate Data,
        LocalTime Horario,
        String Local,
        String Descricao,
        String participantes,
        boolean Disponivel

) {

    private static final int CAMPOS = ObjectFesta.class.getRecordComponents().length;

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

        return List.of(Nome, dataString(), horarioString(), Local, Descricao, "" + participantes, "" + Disponivel);
    }


    public static List<String> desconstruirTodos(List<ObjectReuniao> todos) {

        var listona = new ArrayList<String>(todos.size() * CAMPOS);

        for (var f : todos) {
            listona.addAll(f.desconstruir());
        }

        return listona;
    }


    public static ObjectReuniao construir(List<String> listinha) {

        if (listinha.size() != CAMPOS) throw new IllegalArgumentException();
        return new ObjectReuniao(
                listinha.get(0),
                LocalDate.parse(listinha.get(1), DATA),
                LocalTime.parse(listinha.get(2), HORA),
                listinha.get(3),
                listinha.get(4),
                listinha.get(5),
                Boolean.parseBoolean(listinha.get(6))
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
        return tudo.stream().filter(f -> f.Nome().equals(nomeProcurado)).findAny();
    }
    public static Optional<ObjectReuniao> buscarhorario(List<ObjectReuniao> tudo, String horarioprocurado) {
        return tudo.stream().filter(f -> f.Horario().equals(horarioprocurado)).findAny();
    }
    public static Optional<ObjectReuniao> buscarData(List<ObjectReuniao> tudo, String dataProcurada) {
        return tudo.stream().filter(f -> f.Data().equals(dataProcurada)).findAny();
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

    private static void mostrarReuniao(ObjectReuniao f) {
        System.out.println("Nome: " + f.Nome());
        System.out.println("Data: " + f.dataString());
        System.out.println("Horario: " + f.Horario());
        System.out.println("Local: " + f.Local());
        System.out.println("Descrição: " + f.Descricao());
        System.out.println("Participantes:");
        var arrPart = ListaParticipantes.converterStringEmParticipantes(f.participantes);
        for(var nome: arrPart){
            System.out.println("    • " + nome);
        }
    }

    public static void listarReuniao() {
        var reuniao = Txt_Reuniao.lerTudo();
        for (var f : reuniao) {
            System.out.println();
            mostrarReuniao(f);
        }
    }

}