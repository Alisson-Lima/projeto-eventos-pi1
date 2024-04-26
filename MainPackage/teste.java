package MainPackage;
import java.util.List;
public class teste {

    public static void main (String[] args) {

        List<CriarFesta.Festa> festasCriadas = CriarFesta.addFesta();

        for (CriarFesta.Festa festa : festasCriadas) {
            System.out.println("ID: "+ festa.ID);

        }
    }
}
