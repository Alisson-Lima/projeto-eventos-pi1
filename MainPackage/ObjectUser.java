package MainPackage;

import java.util.Optional;
import  java.util.List;
import java.util.ArrayList;

public record ObjectUser(

        String  Nome,
        String  Sobrenome,
        String  Data_Nasc,
        String  CPF_OU_CNPJ,
        String  Telefone,
        String  Email,
        String  Senha

){


    private static final int CAMPOS = ObjectUser.class.getRecordComponents().length;

    public List<String> desconstruir() {

        return List.of(Nome, Sobrenome, Data_Nasc, CPF_OU_CNPJ, Telefone, Email, Senha);
    }


    public static List<String> desconstruirTodos(List<ObjectUser> todos) {

        var listona = new ArrayList<String>(todos.size() * CAMPOS);

        for (var u : todos) {
            listona.addAll(u.desconstruir());
        }

        return listona;
    }


    public static ObjectUser construir(List<String> listinha) {

        if (listinha.size() != CAMPOS) throw new IllegalArgumentException();

        return new ObjectUser(

                listinha.get(0),
                listinha.get(1),
                listinha.get(2),
                listinha.get(3),
                listinha.get(4),
                listinha.get(5),
                listinha.get(6)

        );
    }


    public static List<ObjectUser> construirTodos (List<String> listona) {

        if (listona.size() % CAMPOS != 0) throw new IllegalArgumentException();

        var resultado = new ArrayList<ObjectUser>(listona.size() / CAMPOS);

        for (int i = 0; i < listona.size(); i += CAMPOS) {

            var listinha = listona.subList(i, i + CAMPOS);
            var elemento = construir(listinha);
            resultado.add(elemento);
        }

        return resultado;
    }


    public static List<ObjectUser> BuscarUser_JaCadastrado(List<ObjectUser> tudo, String CPF_OU_CNPJ, String Telefone, String Email) {
        return   tudo.stream()
                .filter(v -> v.CPF_OU_CNPJ().equalsIgnoreCase(CPF_OU_CNPJ) && v.Telefone().equals(Telefone)  && v.Email().equals(Email))
                .toList();
    }

    public static Optional<ObjectUser>  BuscarUser_CPFOUCNPJ(List<ObjectUser> tudo, String CPF_OU_CNPJ) {
        return   tudo.stream()
                .filter(v -> v.CPF_OU_CNPJ().equalsIgnoreCase(CPF_OU_CNPJ)).findAny();
    }

    public static Optional<ObjectUser>  BuscarUser_Telefone(List<ObjectUser> tudo, String Telefone) {
        return   tudo.stream()
                .filter(v -> v.Telefone().equalsIgnoreCase(Telefone)).findAny();
    }

    public static Optional<ObjectUser>  BuscarUser_Email(List<ObjectUser> tudo, String Email) {
        return   tudo.stream()
                .filter(v -> v.Email().equalsIgnoreCase(Email)).findAny();
    }

    public static Optional<ObjectUser>  BuscarUser_EmaileSenha(List<ObjectUser> tudo, String Email ,String Senha) {
        return  tudo.stream()
                .filter(v -> v.Email().equalsIgnoreCase(Email) && v.Senha().equalsIgnoreCase(Senha)).findAny();
    }

}
