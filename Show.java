/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.show;
/*import com.mycompany.show.Show; SUBSTITUIR PELO LEITOR DO PROJETO
/**
 *
 * Wersington
 */
public class Show{

    
	public static String[] RegisterShow(){
                String[] showTotal = {"","","","","","","",""};//VAI RETORNAR UM RRAY COM ESSAS INFORMAÇÕES
                String[] info = {" o Nome "," a Data "," o Local "," o Horario "," o Limite de ingressos ",
                         " o Horario "," a Descrição ", "Disponíveis? "};
                String[] infogeneric = {"Digite","do Show: "};
                Boolean avaliable = true;
                
                for(int i = 0; i <=  6; i++){
                    System.out.println(infogeneric[0] + info[i]+ infogeneric[1]);
                    String dados = LerDados.readString("tenteNovamente");//SUBSTITUIR DEPOIS PELO LEITOR GERAL
                    showTotal[i] = dados;                 
                }
                
                while(avaliable == true){
                    System.out.println("As vendas de ingressos estão" + info[7] + "[S]sim/[n]Não");
                    String sells = LerDados.readString("tenteNovamente");//SUBSTITUIR DEPOIS PELO LEITOR GERAL
                    if(sells.toUpperCase().equals("N")){
                        avaliable = false;
                        showTotal[7] = "false";
                        }else if(sells.toUpperCase().equals("S")){
                        avaliable = false;
                        showTotal[7] = "true";
                            }else{
                            System.out.println("Valor Invalido Tente novamente");
                            avaliable = true;}
                }
                /* Printar para ver o resultado:
                for(int c = 0; c <= 7; c++){
                System.out.println(showTotal[c]);
                }*/
                return showTotal;
    }
}
