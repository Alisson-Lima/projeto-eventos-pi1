package MainPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public record ObjectComicio
            (
        String Nome,
        String Data,
        String Horario,
        String Local,
        String Partido,
        String Descricao,
        Boolean Autorizacao){



            private static final int CAMPOS = ObjectComicio.class.getRecordComponents().length;


    public List<String> desconstruir() {
        return List.of(Nome,Data,Horario,Local,Partido,Descricao, "" + Autorizacao);
    }


    public static List<String> desconstruirTodos(List<ObjectComicio> todos){
        var listona = new ArrayList<String>(todos.size()*CAMPOS);
        for(var c : todos){
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
                listinha.get(3),
                listinha.get(4),
                listinha.get(5),
                Boolean.parseBoolean(listinha.get(6))
        );
    }
    public static List<ObjectComicio> construirTodos (List<String> listona) {
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
    public static Optional<ObjectComicio> buscarhorario(List<ObjectComicio> tudo, String horarioprocurado) {
        return tudo.stream().filter(c -> c.Horario().equals(horarioprocurado)).findAny();
    }
    public static Optional<ObjectComicio> buscarData(List<ObjectComicio> tudo, String dataProcurada) {
        return tudo.stream().filter(c -> c.Data().equals(dataProcurada)).findAny();
    }
    public static void buscarComicio() {
        System.out.println();
        System.out.print("Digite o nome do Comcio: ");
        var nomesComicio = lerDados.lerTexto("Inválido");

        var comicios = Txt_Comicio.lerTudo();
        var encontrou = ObjectComicio.buscarNome(comicios, nomesComicio);
        if (encontrou.isEmpty()) {
            System.out.println("Não encontrei esse comicio.");
        } else {
            mostrarComicio(encontrou.get());
        }
    }

    private static void mostrarComicio(ObjectComicio c) {
        System.out.println("Nome: " + c.Nome()       );
        System.out.println("Data: " + c.Data()    );
        System.out.println("Horario: " + c.Horario()    );
        System.out.println("Local: " + c.Local()    );
        System.out.println("Partido: " + c.Partido()    );
        System.out.println("Descrição: " + c.Descricao()    );
        System.out.println("Autorização: " + c.Autorizacao()    );
    }

    public static void listarComicios() {
        var comicios = Txt_Comicio.lerTudo();
        for (var c : comicios) {
            System.out.println();
            mostrarComicio(c);
        }
    }
}






