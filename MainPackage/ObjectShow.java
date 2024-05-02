package MainPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record ObjectShow (

         String nome,
         String data,
         String local,
         String horario,
         String descricao,
         int limiteIngressos,
         Boolean ingressosDisponiveis){

        private static final int CAMPOS = ObjectShow.class.getRecordComponents().length;


        public List<String> desconstruir() {
            return List.of(nome,data,local,horario,"" + limiteIngressos, descricao, "" + ingressosDisponiveis);
        }


        public static List<String> desconstruirTodos(List<ObjectShow> todos){
            var listona = new ArrayList<String>(todos.size()*CAMPOS);
            for(var s : todos){
                listona.addAll(s.desconstruir());
            }
            return listona;
        }

        public static ObjectShow construir(List<String> listinha) {
            if (listinha.size() != CAMPOS) throw new IllegalArgumentException();
            return new ObjectShow(

                    listinha.get(0),
                    listinha.get(1),
                    listinha.get(2),
                    listinha.get(3),
                    listinha.get(4),
                    Integer.parseInt(listinha.get(5)),
                    Boolean.parseBoolean(listinha.get(6))
            );
        }
            public static List<ObjectShow> construirTodos (List<String> listona) {
                if (listona.size() % CAMPOS != 0) throw new IllegalArgumentException();
                var resultado = new ArrayList<ObjectShow>(listona.size() / CAMPOS);
                for (int i = 0; i < listona.size(); i += CAMPOS) {
                    var listinha = listona.subList(i, i + CAMPOS);
                    var elemento = construir(listinha);
                    resultado.add(elemento);
                }
                return resultado;
            }

    public static Optional<ObjectShow> buscarLocal(List<ObjectShow> tudo, String localProcurado) {
        return tudo.stream().filter(v -> v.local().equals(localProcurado)).findAny();
    }
    public static Optional<ObjectShow> buscarhorario(List<ObjectShow> tudo, String horarioprocurado) {
        return tudo.stream().filter(v -> v.horario().equals(horarioprocurado)).findAny();
    }
    public static Optional<ObjectShow> buscarData(List<ObjectShow> tudo, String dataProcurada) {
        return tudo.stream().filter(v -> v.data().equals(dataProcurada)).findAny();
    }

        }












        /*
       /public static RegisterShow Showcad(List<String> cadastroShow){
            if(cadastroShow.size() !=7){
                throw new IllegalArgumentException("A lista tem que ter 7 elementos ");
            }
    } 

        public static List<String> CadShow(){


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
        }*/

