package MainPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public record ObjectReuniao
        (
                String Nome,
                String Data,
                String Horario,
                String Local,
                String Descricao,
                int Limite_Participantes){



    private static final int CAMPOS = ObjectReuniao.class.getRecordComponents().length;


    public List<String> desconstruir() {
        return List.of(Nome,Data,Horario,Local,Descricao, "" + Limite_Participantes, "");
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
                listinha.get(3),
                listinha.get(4),
                Integer.parseInt(listinha.get(5))

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

    public static Optional<ObjectReuniao> buscarLocal(List<ObjectReuniao> tudo, String localProcurado) {
        return tudo.stream().filter(v -> v.Local().equals(localProcurado)).findAny();
    }
    public static Optional<ObjectReuniao> buscarhorario(List<ObjectReuniao> tudo, String horarioprocurado) {
        return tudo.stream().filter(v -> v.Horario().equals(horarioprocurado)).findAny();
    }
    public static Optional<ObjectReuniao> buscarData(List<ObjectReuniao> tudo, String dataProcurada) {
        return tudo.stream().filter(v -> v.Data().equals(dataProcurada)).findAny();
    }

}