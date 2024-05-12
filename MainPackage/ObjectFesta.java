package MainPackage;

import  java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public record ObjectFesta(

//      int ID,
        String Nome,
        String Data,
        String Horario,
        String Local,
        String Descricao,
        int Limite_Participantes,
//        String[] Participantes,
        boolean Disponivel

){

//    private static int nextID = 1;
//
//    public FestaObject {
//        ID = nextID++;
//    }

//    public FestaObject {
//        Participantes = new String[Limite_Participantes];
//    }

    private static final int CAMPOS = ObjectFesta.class.getRecordComponents().length;

    public List<String> desconstruir() {

        return List.of(Nome, Data, Horario, Local, Descricao, "" + Limite_Participantes, "" + Disponivel);
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
                listinha.get(3),
                listinha.get(4),
                Integer.parseInt(listinha.get(5)),
//                new String[]{listinha.get(6)},
                Boolean.parseBoolean(listinha.get(6))

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

    private static void mostrarFesta(ObjectFesta f) {
        System.out.println("Nome: " + f.Nome());
        System.out.println("Data: " + f.Data());
        System.out.println("Horario: " + f.Horario());
        System.out.println("Local: " + f.Local());
        System.out.println("Descrição: " + f.Descricao());
        System.out.println("Limite de Ingressos: " + f.Limite_Participantes());
        System.out.println("Ingressos Disponiveis: " + f.Disponivel());
    }

    public static void listarFesta() {
        var festa = Txt_Festa.lerTudo();
        for (var f : festa) {
            System.out.println();
            mostrarFesta(f);
        }
    }
}



