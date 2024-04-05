import java.util.Scanner;

public class Main {
    private static Scanner userPrompt = new Scanner(System.in);

    public static void main(String[] args) {

        welcomeMsg();
        
    }

    public static void welcomeMsg(){
        System.out.println(
        "|===============================|\n"+
        "|                               |\n"+
        "|                               |\n"+
        "|                               |\n"+
        "|       B E M - V I N D O S     |\n"+
        "|                               |\n"+
        "|     A plataforma de Eventos   |\n"+
        "|          Project X            |\n"+
        "|                               |\n"+
        "|                               |");
        mainMenuOptions();
    }
    
    public static void mainMenuOptions(){
        System.out.println(
        "|===============================|\n"+
        "|                               |\n"+
        "|   Selecione uma das opções:   |\n"+
        "|   1 - SHOW                    |\n"+
        "|   2 - REUNIÃO                 |\n"+
        "|   3 - FESTA                   |\n"+
        "|   4 - COMÍCIO                 |\n"+
        "|   5 - SAIR                    |\n"+
        "|                               |\n"+
        "|===============================|\n"); 
        getUserChoice();
    }

    public static void getUserChoice(){

        String optionSelect = userPrompt.nextLine();
        switch (optionSelect) {
            case "1":
                selectShow();
                break;
            case "2":
                selectReuniao();
                break;
            case "3":
                selectFesta();
                break;
            case "4":
                selectComicio();
                break;
            case "5":
                exit();
                break;
            default: 
                System.out.println("Opção inválida! Escolha uma opção de 1 a 5! \n");
                mainMenuOptions();

        }
       
    }
    
    public static void selectShow(){

        System.out.println("|===============================|\n"+
                            "|                               |\n"+
                            "|   OPÇÕES DO MENU SHOW:        |\n"+
                            "|                               |\n"+
                            "|   1 - CRIAR SHOW              |\n"+
                            "|   2 - PESQUISAR SHOW          |\n"+
                            "|   3 - MENU PRINCIPAL          |\n"+
                            "|   4 - SAIR                    |\n"+
                            "|                               |\n"+
                            "|===============================|\n"); 
        String optionMenuShow = userPrompt.nextLine();

        switch (optionMenuShow) {
            case "1":
                System.out.println("CRIAR SHOW");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "2":
                System.out.println("PESQUISAR SHOW");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "3":
                System.out.println("VOLTANDO PARA O MENU");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "4":
                exit();
            break;
            default:
                System.out.println("Opção inválida! Voltando para o início...\n");
                mainMenuOptions();
        }

    }

    public static void selectReuniao(){
        System.out.println("|===============================|\n"+
                            "|                               |\n"+
                            "|   OPÇÕES DO MENU REUNIÃO:     |\n"+
                            "|                               |\n"+
                            "|   1 - CRIAR REUNIÃO           |\n"+
                            "|   2 - PESQUISAR REUNIÃO       |\n"+
                            "|   3 - MENU PRINCIPAL          |\n"+
                            "|   4 - SAIR                    |\n"+
                            "|                               |\n"+
                            "|===============================|\n"); 
        String optionMenuShow = userPrompt.nextLine();

        switch (optionMenuShow) {
            case "1":
                System.out.println("CRIAR REUNIÃO");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "2":
                System.out.println("PESQUISAR REUNIÃO");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "3":
                System.out.println("VOLTANDO PARA O MENU");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "4":
                exit();
            break;
            default:
                System.out.println("Opção inválida! Voltando para o início...\n");
                mainMenuOptions();
        }
    }

    public static void selectFesta(){
       System.out.println("|===============================|\n"+
                            "|                               |\n"+
                            "|   OPÇÕES DO MENU FESTA:       |\n"+
                            "|                               |\n"+
                            "|   1 - CRIAR FESTA             |\n"+
                            "|   2 - PESQUISAR FESTA         |\n"+
                            "|   3 - MENU PRINCIPAL          |\n"+
                            "|   4 - SAIR                    |\n"+
                            "|                               |\n"+
                            "|===============================|\n"); 
        String optionMenuShow = userPrompt.nextLine();

        switch (optionMenuShow) {
            case "1":
                System.out.println("CRIAR FESTA");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "2":
                System.out.println("PESQUISAR FESTA");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "3":
                System.out.println("VOLTANDO PARA O MENU");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "4":
                exit();
            break;
            default:
                System.out.println("Opção inválida! Voltando para o início...\n");
                mainMenuOptions();
        }
    }

    public static void selectComicio(){
        System.out.println("|===============================|\n"+
                            "|                               |\n"+
                            "|   OPÇÕES DO MENU COMICIO:     |\n"+
                            "|                               |\n"+
                            "|   1 - CRIAR COMICIO           |\n"+
                            "|   2 - PESQUISAR COMICIO       |\n"+
                            "|   3 - MENU PRINCIPAL          |\n"+
                            "|   4 - SAIR                    |\n"+
                            "|                               |\n"+
                            "|===============================|\n"); 
        String optionMenuShow = userPrompt.nextLine();

        switch (optionMenuShow) {
            case "1":
                System.out.println("CRIAR COMICIO");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "2":
                System.out.println("PESQUISAR COMICIO");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "3":
                System.out.println("VOLTANDO PARA O MENU");
                System.out.println("(FUNÇÃO EM DESENVOLVIMENTO)");
                System.out.println("Voltando para o início...");
                mainMenuOptions();
            break;
            case "4":
                exit();
            break;
            default:
                System.out.println("Opção inválida! Voltando para o início...\n");
                mainMenuOptions();
        }
    }

    public static void exit(){
        System.out.println("Finalizando programa...");
        System.exit(0);
    }

}

