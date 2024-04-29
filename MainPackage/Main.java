package MainPackage;

import java.util.Scanner;

public class Main {

    /* Variaveis de uso geral */ 
    private static Scanner userPrompt = new Scanner(System.in);
    
    private static String [] menuOptionsArray = {"SHOW", "REUNIÃO", "FESTA   ", "COMICIO"};
    
    private static String [] loginUserInfosVar =new String[]{"Admin"};

    private static String [] loginPassInfosVar = new String[]{"1234"};
    private static boolean loginInfosKey = false;

    /* Função principal */
    public static void main(String[] args) {

        loginVerificate();
        
    }
    /*Função usada para verificar caso usuario esteja conectado */
    public static void loginVerificate(){
        while (loginInfosKey == false) {
            System.out.print("=========================================================\n");
                System.out.println("|            Olá, Aguarde enquanto Verificamos          |"); 
                for(int i=90;i<100; i++){}
                System.out.print( "=========================================================\n");
                     
            System.out.println("Você não possui uma sessão ativa no sistema!\n"+
            "Por favor efetue o Login\n"+"Ou faça o cadastro");
            System.out.println("Opções\n"+"1 - Login \n"+"2 - Cadastro\n"+"3 - Sair"); 
            int arrayUserNameLenght = loginPassInfosVar.length;
            int opcaoMenuLog = userPrompt.nextInt();
            if (opcaoMenuLog == 1) {
                System.out.println("Digite seu Nome de Usuario: ");
                String nameUser = userPrompt.next();
                System.out.println("Digite sua Senha: ");
                String passUser = userPrompt.next();
                if (nameUser.equals(loginUserInfosVar[0]) && passUser.equals(loginPassInfosVar[0]) ) {
                    loginInfosKey = true;
                    welcomeMsg();
                }
            }
            else if(opcaoMenuLog == 2){
                System.out.println("Bem-Vindo a area de cadastro!! ");
                System.out.println("Digite o Nome de Usuario que deseja: ");
                
                String nameUser2 = userPrompt.next();

                System.out.println("Digite a sua Senha de preferencia: ");
                String passUser = userPrompt.next();
                
                System.out.println("Digite novamente a sua Senha: ");
                String passUserConfirm = userPrompt.next();

                if (passUser.equals(passUserConfirm)) {
                    //loginUserInfosVar[arrayUserNameLenght+1].add(nameUser2);
                    //loginPassInfosVar[arrayUserNameLenght+1].add(passUser);
                    // System.out.println(nameString);

//                    loginInfosKey = true;
                    loginVerificate();
                    System.out.println("Parabéns Sr/Sra "+nameUser2+" seu usuario foi criado");

                }
            }
            else if( opcaoMenuLog == 3){
                exit();
            }else{

                System.out.println("Opção invalida!!");
            }

        }
            welcomeMsg();
        
    }
    /*Função de mensagem de boas vindas */
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
    /*Função de mensagem opções menu */
    
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

    /*Função que pega a opção do menu */

    public static void getUserChoice(){

        int optionSelect = userPrompt.nextInt();

        if (optionSelect<=4) {
            printMenuOptionsOfSelectedMenu(optionSelect);
        }
        else if(optionSelect==5){
            exit();
        }else{
            System.out.println("Opção inválida! Escolha uma opção de 1 a 5! \n");
                mainMenuOptions();
        }
        
       
    }
    /*Função que mostra o menu pos seleção */
    
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
                    mainMenuOptions();

                    break;
                    case 2:
                    System.out.println("PESQUISAR "+nameOfArray+"\n");
                    mainMenuOptions();

                    
                    break;
                case 3:
                    mainMenuOptions();
                    break;
            
                default:
                    printMenuOptionsOfSelectedMenu(menuOptions);
            }
        }
    }
    /*Função para fechar execução */
    public static void exit(){
        System.out.println("Finalizando programa...");
        System.exit(0);
    }

}

