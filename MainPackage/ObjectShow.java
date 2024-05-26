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
    public static void cadVenda(){
        Boolean respostinha = false;

        System.out.println("De qual evento você deseja cadastrar a venda: ");
        var nomeEvento = lerDados.lerTexto("Inválido tente novamente:");
        var shows = Txt_Show.lerTudo();
        var nomeShow = ObjectShow.buscarNome(shows,nomeEvento);

        if(nomeShow.isEmpty()){
            System.out.println("Show não encontrado");
            return;
        }
            ObjectShow show = nomeShow.get();
        if(!show.ingressosDisponiveis()){
            System.out.println("Não há ingressos disponíveis");
            System.out.println("Deseja que os ingressos fiquem disponíveis: [S]Sim [N]Não");
            var resposta = lerDados.lerSimNao("Opção inválida tente novamente: [S]Sim [N]Não");
            if(resposta){
              respostinha = true;
            }else{
            return;}
        }
        if(show.ingressosDisponiveis() || respostinha){
            System.out.println("Digite as vendas feitas: ");
            int venda = lerDados.lerInt("Valor Inválido tente novamente");
            int b = show.limiteIngressos;
            if(venda > b ){
                System.out.println("Venda maior que o limite de ingressos");
                return;
            }else if(venda <= 0){
                System.out.println("Número inválido");
            }else {
                int ingressosRestantes = show.limiteIngressos - venda;
                System.out.println("Ingressos restantes: " + ingressosRestantes);
                if (ingressosRestantes == 0) {
                    respostinha = false;
                    ObjectShow novoshow = new ObjectShow(
                            show.nome(),
                            show.data(),
                            show.horario(),
                            show.local(),
                            show.descricao(),
                            ingressosRestantes,
                            respostinha);
                    int index = shows.indexOf(show);
                    shows.set(index, novoshow);

                    Txt_Show.salvarTudo(shows);

                    }else {
                    ObjectShow novoshow = new ObjectShow(
                            show.nome(),
                            show.data(),
                            show.horario(),
                            show.local(),
                            show.descricao(),
                            ingressosRestantes,
                            respostinha);
                    int index = shows.indexOf(show);
                    shows.set(index, novoshow);

                    Txt_Show.salvarTudo(shows);
                }
            }
        }
    }
}
