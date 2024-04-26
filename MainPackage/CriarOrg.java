package MainPackage;

public class CriarOrg {

    public record userOrgObject (
            int nextID = 1;

            int ID;
            String Nome;
            String Sobrenome;
            String DataNasc;
            String CPFouCNPJ;
            String Telefone;
            String Email;
            String Senha;
    ) {
        public static User construir(List<String> listinha) {
            if (listinha.size() != CAMPOS) throw new IllegalArgumentException();
            return new User(
                    listinha.get(0).toUpperCase(),
                    listinha.get(1),
                    listinha.get(2),
                    listinha.get(3),
                    listinha.get(4),
                    listinha.get(5),
                    listinha.get(6),
                    listinha.get(7)

            );
        }

    }






}
