import java.util.Scanner;

public class Main {
    private static Scanner userPrompt = new Scanner(System.in);
    
    private static String [] menuOptionsArray = {"SHOW", "REUNIÃO", "FESTA   ", "COMICIO"};
    
    private static String loginUserInfosVar ="Admin";
    private static String loginPassInfosVar ="1234";
    private static boolean loginInfosKey = false;

    
    public static void main(String[] args) {

        loginVerificate();
        
    }
    public static void loginVerificate(){
        if (loginInfosKey == false) {
            System.out.println("Olá, Verificamos que você não possui uma sessão ativa no sistema!\n"+
            "Por favor efetue o Login");
            System.out.print("Digite seu Nome de Usuario: ");
            String nameUser = userPrompt.nextLine();
            System.out.print("Digite sua Senha: ");
            String passUser = userPrompt.nextLine();

            if (nameUser.equals(loginUserInfosVar) && passUser.equals(loginPassInfosVar) ) {
                loginInfosKey = true;
                welcomeMsg();
            }
        }else{
            welcomeMsg();
        }
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
        "|   1 - "+menuOptionsArray[0]+"                    |\n"+
        "|   2 - "+menuOptionsArray[1]+"                 |\n"+
        "|   3 - "+menuOptionsArray[2]+"                |\n"+
        "|   4 - "+menuOptionsArray[3]+"                 |\n"+
        "|   5 - SAIR                    |\n"+
        "|                               |\n"+
        "|===============================|\n"); 
        getUserChoice();
    }

    public static void getUserChoice(){

        int optionSelect = userPrompt.nextInt();

        if (optionSelect<=5) {
            printMenuOptionsOfSelectedMenu(optionSelect);
        }else{
            System.out.println("Opção inválida! Escolha uma opção de 1 a 5! \n");
                mainMenuOptions();
        }
        
       
    }
    
    public static void printMenuOptionsOfSelectedMenu(int menuOptions ){
        String nameOfArray = menuOptionsArray[menuOptions-1];
        System.out.println( "|=================================|\n"+
                            "|                                 |\n"+
                            "|     OPÇÕES DO MENU COMICIO:     |\n"+
                            "|                                 |\n"+
                            "|   1 - CRIAR "+nameOfArray+"            |\n"+
                            "|   2 - PESQUISAR "+nameOfArray+"        |\n"+
                            "|   3 - MENU PRINCIPAL            |\n"+
                            "|   4 - SAIR                      |\n"+
                            "|                                 |\n"+
                            "|=================================|\n");
                            
        int optionSelectService = userPrompt.nextInt();
        if (optionSelectService == 4) {
            exit();
        }else{
            switch (optionSelectService) {
                case 1:
                    System.out.println("CRIAR "+nameOfArray+"\n");
                    break;
                    case 2:
                    System.out.println("PESQUISAR "+nameOfArray+"\n");
                    
                    break;
                case 3:
                    mainMenuOptions();
                    break;
            
                default:
                    printMenuOptionsOfSelectedMenu(menuOptions);
            }
        }
    }
    public static void exit(){
        System.out.println("Finalizando programa...");
        System.exit(0);
    }

}

