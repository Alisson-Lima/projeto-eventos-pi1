package MainPackage;

import java.util.Arrays;
import java.util.List;

public class CriarShow {
    
    public record RegisterShow(

         String nome,
         String data,
         String local,
         String horario,
         int limiteIngressos,
         String descricao,
         Boolean ingressosDisponiveis){
        

        public static RegisterShow Showcad(List<String> cadastroShow){
            if(cadastroShow.size() !=7){
                throw new IllegalArgumentException("A lista tem que ter 7 elementos ");
            }
            return new RegisterShow(cadastroShow.get(0), 
            cadastroShow.get(1), 
            cadastroShow.get(2), 
            cadastroShow.get(3), 
            Integer.parseInt(cadastroShow.get(4)), 
            cadastroShow.get(5),
            Boolean.parseBoolean(cadastroShow.get(6)));
        }
    } 

        public static List<String> CadShow(){
            System.out.println("__________Cadasto de Show_________\nNome do Show: ");
            var nome = lerDados.lerTexto(null);
            System.out.println("Data do Show: ");
            var data = lerDados.lerTexto(null);     
            System.out.println("Local do Show: ");
            var local = lerDados.lerTexto(null);
            System.out.println("Horario do Show: ");
            var horario = lerDados.lerTexto(null);
            System.out.println("Limites de ingressos do Show: ");
            var limiteIngressos = lerDados.lerInt(null);
            System.out.println("Descrição do Show: ");
            var descricao = lerDados.lerTexto(null); 
            System.out.println("Os ingressos estão disponiveis? Sim[S] Não[N]");
            var ingressosDisponiveis = lerDados.lerTexto(null);

            if(ingressosDisponiveis.equals("s") == true){
               ingressosDisponiveis = "true";
            }else{
                ingressosDisponiveis = "false";
            }

            boolean ingressosDisponiveisBool = ingressosDisponiveis.equalsIgnoreCase("s");

            var show = new RegisterShow(nome, data, local, horario, limiteIngressos, descricao, ingressosDisponiveisBool);
            return Arrays.asList(nome, data, local, horario, String.valueOf(limiteIngressos), descricao, ingressosDisponiveis);
        }

        public static void Printshow(){
            List<String> listaShow = CadShow(); // Obtém a lista de dados do show  
            RegisterShow show = RegisterShow.Showcad(listaShow);
            System.out.println(show);
        }
}
