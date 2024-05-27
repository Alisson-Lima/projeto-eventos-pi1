package MainPackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public record ObjectComicio
        (
                String Id,
                String Proprietario,
                String Nome,
                LocalDate DataInicio,
                LocalDate DataFim,
                LocalTime HorarioInicio,
                LocalTime HorarioFim,
                String Local,
                String Partido,
                String Descricao,
                Boolean Autorizacao) {


    private static final int CAMPOS = ObjectComicio.class.getRecordComponents().length;

    private static final DateTimeFormatter DATA = DateTimeFormatter
            .ofPattern("dd/MM/uuuu")
            .withChronology(IsoChronology.INSTANCE)
            .withResolverStyle(ResolverStyle.STRICT);

    private static final DateTimeFormatter HORA = DateTimeFormatter
            .ofPattern("HH:mm")
            .withChronology(IsoChronology.INSTANCE)
            .withResolverStyle(ResolverStyle.STRICT);


    public String dataInicioString() {
        return DATA.format(DataInicio);
    }

    public String dataFimString() {
        return DATA.format(DataFim);
    }

    public String horarioInicioString() {
        return HORA.format(HorarioInicio);
    }

    public String horarioFimString() {
        return HORA.format(HorarioFim);
    }

    public List<String> desconstruir() {
        return List.of(Id, Proprietario, Nome, dataInicioString(), dataFimString(), horarioInicioString(), horarioFimString(), Local, Partido, Descricao, "" + Autorizacao);
    }


    public static List<String> desconstruirTodos(List<ObjectComicio> todos) {
        var listona = new ArrayList<String>(todos.size() * CAMPOS);
        for (var c : todos) {
            listona.addAll(c.desconstruir());
        }
        return listona;
    }

    public static ObjectComicio construir(List<String> listinha) {
        if (listinha.size() != CAMPOS) throw new IllegalArgumentException();
        return new ObjectComicio(

                listinha.get(0),
                listinha.get(1),
                listinha.get(2),
                LocalDate.parse(listinha.get(3), DATA),
                LocalDate.parse(listinha.get(4), DATA),
                LocalTime.parse(listinha.get(5), HORA),
                LocalTime.parse(listinha.get(6), HORA),
                listinha.get(7),
                listinha.get(8),
                listinha.get(9),
                Boolean.parseBoolean(listinha.get(10))
        );
    }

    public static List<ObjectComicio> construirTodos(List<String> listona) {
        if (listona.size() % CAMPOS != 0) throw new IllegalArgumentException();
        var resultado = new ArrayList<ObjectComicio>(listona.size() / CAMPOS);
        for (int i = 0; i < listona.size(); i += CAMPOS) {
            var listinha = listona.subList(i, i + CAMPOS);
            var elemento = construir(listinha);
            resultado.add(elemento);
        }
        return resultado;
    }

    public static Optional<ObjectComicio> buscarNome(List<ObjectComicio> tudo, String nomeProcurado) {
        return tudo.stream().filter(c -> c.Nome().equals(nomeProcurado)).findAny();
    }

    public static Optional<ObjectComicio> buscarId(List<ObjectComicio> tudo, String idProcurado) {
        return tudo.stream().filter(c -> c.Id().equals(idProcurado)).findAny();
    }

    public static Optional<ObjectComicio> buscarProprietario(List<ObjectComicio> tudo, String Proprietarios) {
        return tudo.stream().filter(c -> c.Proprietario().equals(Proprietarios)).findAny();
    }

    public static Optional<ObjectComicio> buscardatainicio(List<ObjectComicio> tudo, LocalDate dataInicioPocruada) {
        return tudo.stream().filter(c -> c.DataInicio().equals(dataInicioPocruada)).findAny();
    }

    public static Optional<ObjectComicio> buscardatafim(List<ObjectComicio> tudo, LocalDate dataFimPocruada) {
        return tudo.stream().filter(c -> c.DataFim().equals(dataFimPocruada)).findAny();
    }

    public static Optional<ObjectComicio> buscarhorarioinicio(List<ObjectComicio> tudo, LocalDate horarioInicioProcurado) {
        return tudo.stream().filter(c -> c.HorarioInicio().equals(horarioInicioProcurado)).findAny();
    }

    public static Optional<ObjectComicio> buscarhorariofim(List<ObjectComicio> tudo, LocalDate horarioFimProcurado) {
        return tudo.stream().filter(c -> c.HorarioInicio().equals(horarioFimProcurado)).findAny();
    }

    public static Optional<ObjectComicio> buscarLocal(List<ObjectComicio> tudo, String localProcurado) {
        return tudo.stream().filter(c -> c.Local().equals(localProcurado)).findAny();
    }

    public static void buscarComicio() {

        System.out.print("\nDigite o nome do Comcio: ");
        var nomesComicio = lerDados.lerTexto("Inválido");

        var comicios = Txt_Comicio.lerTudo();
        var encontrou = ObjectComicio.buscarNome(comicios, nomesComicio);
        if (encontrou.isEmpty()) {
            System.out.println("Não encontrei esse comicio.");
        } else {
            mostrarComicio(encontrou.get());
        }
    }

    public static String buscarId(String idComicio) {

        System.out.print("\nDigite o ID: ");

        var comicios = Txt_Comicio.lerTudo();
        var encontrou = ObjectComicio.buscarId(comicios, idComicio);
        if (encontrou.isEmpty()) {
            System.out.println("Não encontrei esse id.");
        }
        return encontrou.toString();
    }

    public static boolean verifyId(String idComicio) {

        var comicios = Txt_Comicio.lerTudo();
        var encontrou = ObjectComicio.buscarId(comicios, idComicio);
        return encontrou.isPresent();
    }

    private static void mostrarComicio(ObjectComicio c) {
        System.out.println("Nome: " + c.Nome());
        System.out.println("Data: " + c.DataInicio());
        System.out.println("Data: " + c.DataFim());
        System.out.println("Horario: " + c.HorarioInicio());
        System.out.println("Horario: " + c.HorarioFim());
        System.out.println("Local: " + c.Local());
        System.out.println("Partido: " + c.Partido());
        System.out.println("Descrição: " + c.Descricao());
        System.out.println("Autorização: " + c.Autorizacao());
    }

}






