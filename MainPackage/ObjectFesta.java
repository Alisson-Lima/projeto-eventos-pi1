package MainPackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Optional;
import  java.util.List;
import java.util.ArrayList;

public record ObjectFesta(
        String Id,
        String Proprietario,
        String Nome,
        LocalDate Data,
        LocalTime Horario,
        String Local,
        String Descricao,
        String participantes,
        boolean Disponivel

){


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

        return List.of(Id, Proprietario,Nome, dataString(), horarioString(), Local, Descricao, "" + participantes, "" + Disponivel);
    }


    public static List<String> desconstruirTodos(List<ObjectFesta> todos) {

        var listona = new ArrayList<String>(todos.size() * CAMPOS);

        for (var f : todos) {
            listona.addAll(f.desconstruir());
        }

        return listona;
    }


    public static ObjectFesta construir(List<String> listinha) {

        if (listinha.size() != CAMPOS) throw new IllegalArgumentException();
        return new ObjectFesta(

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


    public static List<ObjectFesta> construirTodos (List<String> listona) {

        if (listona.size() % CAMPOS != 0) throw new IllegalArgumentException();

        var resultado = new ArrayList<ObjectFesta>(listona.size() / CAMPOS);

        for (int i = 0; i < listona.size(); i += CAMPOS) {

            var listinha = listona.subList(i, i + CAMPOS);
            var elemento = construir(listinha);
            resultado.add(elemento);
        }

        return resultado;
    }
    public static Optional<ObjectFesta> buscarNome(List<ObjectFesta> tudo, String nomeProcurado) {
        return tudo.stream().filter(f -> f.Nome().equals(nomeProcurado)).findAny();
    }
    public static Optional<ObjectFesta> buscarhorario(List<ObjectFesta> tudo, String horarioprocurado) {
        return tudo.stream().filter(f -> f.Horario().equals(horarioprocurado)).findAny();
    }
    public static Optional<ObjectFesta> buscarId(List<ObjectFesta> tudo, String idProcurado) {
        return tudo.stream().filter(f -> f.Id().equals(idProcurado)).findAny();
    }

    public static Optional<ObjectFesta> buscarData(List<ObjectFesta> tudo, String dataProcurada) {
        return tudo.stream().filter(f -> f.Data().equals(dataProcurada)).findAny();
    }

    public static void buscarFesta() {
        System.out.println();
        System.out.print("Digite o nome da Festa: ");
        var nomesFesta = lerDados.lerTexto("Inválido");
        var festa = Txt_Festa.lerTudo();
        var encontrou = ObjectFesta.buscarNome(festa, nomesFesta);
        if (encontrou.isEmpty()) {
            System.out.println("Não encontrei essa Festa.");
        } else {
            mostrarFesta(encontrou.get());
        }
    }

    public static void buscarids() {

        System.out.print("\nDigite o ID: ");
        var idFesta = lerDados.lerTexto("Inválido");
        var festa = Txt_Festa.lerTudo();
        var encontrou = ObjectFesta.buscarId((festa), idFesta.toUpperCase());
        var email = Cadastro_E_Login.Retornar_EmailLogado();
        if (encontrou.isEmpty()) {
            System.out.println("Não encontrei esse id.");
        }else{
            var emailtxt = mostrarProprietario(encontrou.get());
            if(email.equals(emailtxt)){
                mostrarFesta(encontrou.get());
            }else{
                System.out.println("Não encontrei esse id.");
            }

        }
    }

    private static void mostrarFesta(ObjectFesta f) {
        System.out.println("ID: " + f.Id());
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
        System.out.println("Ingressos Disponiveis: " + f.Disponivel());
    }
    private static void mostrarFestas(ObjectFesta f) {
        System.out.println("ID " + f.Id());
        System.out.println("Nome: " + f.Nome());
        System.out.println("Data: " + f.dataString());
        System.out.println("Horario: " + f.Horario());
        System.out.println("Local: " + f.Local());
        System.out.println("Descrição: " + f.Descricao());
        System.out.println("Participantes:");
        System.out.println(mostrarLista(f));
        System.out.println("Ingressos Disponiveis: " + f.Disponivel());
    }
    public static boolean verifyId(String idFesta) {

        var festa = Txt_Festa.lerTudo();
        var encontrou = ObjectFesta.buscarId(festa, idFesta);
        return encontrou.isPresent();
    }

    private static String mostrarProprietario(ObjectFesta f) {

        return f.Proprietario();
    } private static String mostrarLista(ObjectFesta f) {
        var nomes = "";
        var arrPart = ListaParticipantes.converterStringEmParticipantes(f.participantes);
        for(var nome: arrPart){

            nomes += "    • " + nome + "\n";
        }
        return nomes;
    }

    /*
    public static void listarFesta() {
        var festa = Txt_Festa.lerTudo();
        for (var f : festa) {
            System.out.println();
            mostrarFesta(f);
        }
    }*/


    public static void listarFesta() {
        var festa = Txt_Festa.lerTudo();
        var email = Cadastro_E_Login.Retornar_EmailLogado();
        for (var f : festa) {
            var emailtxt = mostrarProprietario(f);
            if (email.equals(emailtxt)){
                System.out.println();
                mostrarFestas(f);
            }
        }
    }

}



