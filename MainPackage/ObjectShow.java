package MainPackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record ObjectShow (

         String nome,
         LocalDate data,
         LocalTime horario,
         String local,
         String descricao,
         int limiteIngressos,
         Boolean ingressosDisponiveis){

        private static final int CAMPOS = ObjectShow.class.getRecordComponents().length;

        private static final DateTimeFormatter DATA = DateTimeFormatter
                .ofPattern("dd/MM/uuuu")
                .withChronology(IsoChronology.INSTANCE)
                .withResolverStyle(ResolverStyle.STRICT);

        private static final DateTimeFormatter HORA = DateTimeFormatter
                .ofPattern("HH:mm")
                .withChronology(IsoChronology.INSTANCE)
                .withResolverStyle(ResolverStyle.STRICT);


        public String dataString() {
            return DATA.format(data);
        }

        public String horarioString() {
            return HORA.format(horario);
        }

        public List<String> desconstruir() {
            return List.of(nome, dataString(), horarioString(), local, descricao,"" + limiteIngressos, "" + ingressosDisponiveis);
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
                    LocalDate.parse(listinha.get(1), DATA),
                    LocalTime.parse(listinha.get(2), HORA),
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

    public static Optional<ObjectShow> buscarNome(List<ObjectShow> tudo, String nomeProcurado) {
        return tudo.stream().filter(s -> s.nome().equals(nomeProcurado)).findAny();
    }
    public static Optional<ObjectShow> buscarhorario(List<ObjectShow> tudo, String horarioprocurado) {
        return tudo.stream().filter(s -> s.horario().equals(horarioprocurado)).findAny();
    }
    public static Optional<ObjectShow> buscarData(List<ObjectShow> tudo, String dataProcurada) {
        return tudo.stream().filter(s -> s.data().equals(dataProcurada)).findAny();
    }
    public static void buscarShow() {
        System.out.println();
        System.out.print("Digite o nome do Show: ");
        var nomesShows = lerDados.lerTexto("Inválido");
        var shows = Txt_Show.lerTudo();
        var encontrou = ObjectShow.buscarNome(shows, nomesShows);
        if (encontrou.isEmpty()) {
            System.out.println("Não encontrei esse Show.");
        } else {
            mostrarShow(encontrou.get());
        }
    }

    private static void mostrarShow(ObjectShow s) {
        System.out.println("Nome: " + s.nome());
        System.out.println("Data: " + s.dataString());
        System.out.println("Horario: " + s.horario());
        System.out.println("Local: " + s.local());
        System.out.println("Descrição: " + s.descricao());
        System.out.println("Limite de Ingressos: " + s.limiteIngressos());
        System.out.println("Ingressos Disponiveis: " + s.ingressosDisponiveis());
    }

    public static void listarShow() {
        var shows = Txt_Show.lerTudo();
        for (var s : shows) {
            System.out.println();
            mostrarShow(s);
        }
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

