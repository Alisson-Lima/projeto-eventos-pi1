package MainPackage;

//import com.mycompany.show.Show.LerDados;//Aqui vou substituir para o package do arquivo

public class Comicio {
    /*public static void main(String args[]){
        registerComicio();
}*/
    public static String[] registerComicio(){
        
        String[] totalInformation = {"","","","",""};
        String[] informationRegister = {"o Nome","a Data","o Local","o Partido","a Descricão"};
        boolean autorizacao = false;
        String opcao = "";
       /* String showInformation = "";*/
            for(int c = 0 ; c < 5; c++)
            {
                System.out.println("Escreva " + informationRegister[c] + " do evento:");
                //totalInformation[c] = LerDados.readString("Tente novamente: ");
                /*showInformation = totalInformation[c]+ " " + showInformation;*/
        }   System.out.println("Você tem autorização para realizar esse comicio?  [S]sim/[n]Não");
            //opcao = LerDados.readString("Tente novamente: ");
            if(opcao.toUpperCase().equals("S")){
                System.out.println("Otimo, Bom Trabalho");
                 autorizacao = true;
            }else{
                System.out.println("Procure um orgão publicom para conseuir a Autorização");
                autorizacao = false;
            }
            /*System.out.println("Informaçcoes: " + showInformation + " ");*/
            if (!autorizacao){
                return new String[0];
            }  
            
            return totalInformation;
}
}