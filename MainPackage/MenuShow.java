package MainPackage;

public class MenuShow {
    public static void menuShow(){

        while (true) {

            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Show");
            System.out.println("2 - Buscar Show");
            System.out.println("X - VOLTAR");
            System.out.println();
            System.out.print("Digite a sua escolha: ");
            var escolha = lerDados.lerTexto("Opção Inválida").toUpperCase();
            if (escolha.equals("1")) {
                cadstrarShow();
            }

        }
    }
        private static void cadstrarShow() {
            //Para um show ser cadastrado pelomeno uma variavel booleana dessas tem que ser falsa
            Boolean localShow = false;
            Boolean dataShow = false;
            Boolean horarioShow = false;
            Boolean ingressosDisponiveis = true;

            System.out.println();
            System.out.println("__________Cadasto de Show_________\nNome do Show: ");
            var nome = lerDados.lerTexto(null);


            System.out.println("Data do Show: ");
            var data = lerDados.lerTexto(null);

            //verificação se exite evento na mesma data
            var show = Txt_Show.lerTudo();
            var Existente = ObjectShow.buscarData(show, data);
            if (Existente.isPresent()){
                dataShow = true;
            }

            System.out.println("Local do Show: ");
            var local = lerDados.lerTexto(null);

            //verificação se exite evento no mesmo local
                show = Txt_Show.lerTudo();
                Existente = ObjectShow.buscarLocal(show, local);
            if (Existente.isPresent()){
                localShow = true;
            }

            System.out.println("Horario do Show: ");
            var horario = lerDados.lerTexto(null);

            //verificação se exite evento no mesmo horario
             show = Txt_Show.lerTudo();
             Existente = ObjectShow.buscarhorario(show, horario);
            if (Existente.isPresent()){
                horarioShow = true;
            }
            if (localShow && dataShow && horarioShow ){
                return;
            }
            System.out.println("Limites de ingressos do Show: ");
            var limiteIngressos = lerDados.lerInt(null);

            System.out.println("Descrição do Show: ");
            var descricao = lerDados.lerTexto(null);

            System.out.println("Os ingressos estão disponiveis? Sim[S] Não[N]");
            var ingressos = lerDados.lerTexto(null);

            if(ingressos.equals("n")){
                ingressosDisponiveis = false;
            }

            var showcad = new ObjectShow(nome, data, local, horario, descricao, limiteIngressos, ingressosDisponiveis);
            Txt_Show.salvar(showcad);
            System.out.println("Show cadastrado");
        }

}
