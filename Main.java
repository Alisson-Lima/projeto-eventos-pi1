import java.util.Scanner;
// public Scanner myObj = new Scanner(System.in);
public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        initMenu();
        


        myObj.close();
    }
    
    public static void initMenu(){
        
        Scanner myObj = new Scanner(System.in);
        
        System.out.println("|===============================|\n"+
        "|                               |\n"+
        "|                               |\n"+
        "|                               |\n"+
        "|       B E M - V I N D O S     |\n"+
        "|                               |\n"+
        "|     A plataforma de Eventos   |\n"+
        "|          Project X            |\n"+
        "|                               |\n"+
        "|                               |\n"+      
        "|                               |\n"+
        "|          Criar Evento         |\n"+
        "|   Selecione uma das opções :  |\n"+
        "|   1 - SHOW                    |\n"+
        "|   2 - REUNIÃO                 |\n"+
        "|   3 - FESTA                   |\n"+
        "|   4 - COMÍCIO                 |\n"+
        "|   5 - SAIR                    |\n"+
        "|                               |\n"+
        "|                               |\n"+
        "|                               |\n"+
        "|===============================|"); 

         System.out.println("Digite a Opção desejada: ");
        String optionSelect = myObj.nextLine();
        switch (optionSelect) {
            case "1":
                selecShow();
                break;
            case "2":
                selecReuniao();
                break;
            case "3":
                selecFesta();
                break;
            case "4":
                selecComicio();
                break;
            case "5":
               exitProg();
                break;
        }
        myObj.close();
    }
    public static void selecShow(){
          Scanner myObj = new Scanner(System.in);
          System.out.println("|===============================|\n"+
                             "|                               |\n"+
                             "|        OPÇÕES DO MENU         |\n"+
                             "|                               |\n"+
                             "|       1 - CRIAR SHOW          |\n"+
                             "|       2 - PESQUISAR SHOW      |\n"+
                             "|       3 - MENU PRINCIPAL      |\n"+
                             "|       4 - SAIR                |\n"+
                             "|                               |\n"+
                             "|                               |\n"+
                             "|===============================|"); 
          String optionMenuShow = myObj.nextLine();

            switch (optionMenuShow) {
                case "1":
                    System.out.println("CRIAR SHOW");
                break;
            
                case "2":
                System.out.println("PESQUISAR SHOW");
                break;
            
                case "3":
                System.out.println("VOLTANDO PARA O MENU");
                initMenu();
                break;
            
                default:
                    break;
            }
          System.out.println("Deseja continuar: (S)im ou (N)ão");
          String optionContinue = myObj.nextLine();
    
          System.out.println(optionContinue);
            switch(optionContinue){
                case "S":
                    initMenu();
                case "N":
                    exitProg();
            }
            myObj.close();
    }
    public static void selecReuniao(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("opt Reunião");
        System.out.println("Deseja continuar: (S)im ou (N)ão");
          String optionContinue = myObj.nextLine();
    
          System.out.println(optionContinue);
            switch(optionContinue){
                case "S":
                    initMenu();
                case "N":
                    exitProg();
            }
            myObj.close();
    }
    public static void selecFesta(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("opt Festa");
        System.out.println("Deseja continuar: (S)im ou (N)ão");
          String optionContinue = myObj.nextLine();
    
          System.out.println(optionContinue);
            switch(optionContinue){
                case "S":
                    initMenu();
                case "N":
                    exitProg();
            }
            myObj.close();
    }
    public static void selecComicio(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("opt Comicio");
        System.out.println("Deseja continuar: (S)im ou (N)ão");
          String optionContinue = myObj.nextLine();
    
          System.out.println(optionContinue);
            switch(optionContinue){
                case "S":
                    initMenu();
                case "N":
                    exitProg();
            }
            myObj.close();
    }
    public static void exitProg(){
        System.out.println("opt Exit");
        System.exit(0);
    }
}

