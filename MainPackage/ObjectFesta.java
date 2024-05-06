package MainPackage;

import  java.util.List;
import java.util.ArrayList;

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



}
