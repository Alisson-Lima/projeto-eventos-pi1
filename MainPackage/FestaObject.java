package MainPackage;

import  java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public record FestaObject (

//        int ID,
        String Nome,
        String Data,
        String Horario,
        String Local,
        String Descricao,
        int Limite_Participantes,
        boolean Disponivel

){

//    private static int nextID = 1;
//
//    public FestaObject {
//        ID = nextID++;
//    }

    private static final int CAMPOS = FestaObject.class.getRecordComponents().length;

    public List<String> desconstruir() {

        return List.of(Nome, Data, Horario, Local, Descricao, "" + Limite_Participantes, "" + Disponivel);
    }


    public static List<String> desconstruirTodos(List<FestaObject> todos) {
        var listona = new ArrayList<String>(todos.size() * CAMPOS);
        for (var v : todos) {
            listona.addAll(v.desconstruir());
        }
        return listona;
    }


    public static FestaObject construir(List<String> listinha) {

        if (listinha.size() != CAMPOS) throw new IllegalArgumentException();

        return new FestaObject(

                listinha.get(0),
                listinha.get(1),
                listinha.get(2),
                listinha.get(3),
                listinha.get(4),
                Integer.parseInt(listinha.get(5)),
                Boolean.parseBoolean(listinha.get(6))

        );
    }


    public static List<FestaObject> construirTodos (List<String> listona) {
        if (listona.size() % CAMPOS != 0) throw new IllegalArgumentException();
        var resultado = new ArrayList<FestaObject>(listona.size() / CAMPOS);
        for (int i = 0; i < listona.size(); i += CAMPOS) {
            var listinha = listona.subList(i, i + CAMPOS);
            var elemento = construir(listinha);
            resultado.add(elemento);
        }
        return resultado;
    }



}
