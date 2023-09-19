/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package execiciofixacao;

import java.util.Scanner;

/**
 *
 * @author Miétje
 */
public class ExecicioFixacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nome;
        float salario;
       
        System.out.println("nome: ");
        nome = in.nextLine();
        System.out.println("salario: ");
        salario = in.nextFloat();
        
        
   
       
       Colaborador co = new Colaborador(nome,salario);
       
       co.triangulo();
        
    }
    
}
