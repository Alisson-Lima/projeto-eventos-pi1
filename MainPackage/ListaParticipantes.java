package MainPackage;

import java.util.ArrayList;
import java.util.List;

public class ListaParticipantes {

    public static String converterArrayParticipantesEmString(ArrayList<String> arrParticipantes){
        String linhaParticipantes = "";

        for(var item: arrParticipantes){
            linhaParticipantes += item+";";
        }

        return linhaParticipantes;
    }

    public static List<String> converterStringEmParticipantes(String linha){
        return List.of(linha.split(";"));
    }

}

