/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package execiciofixacao;

import java.util.Scanner;

/**
 *
 
 */
public class Colaborador implements Regras{
   private String nome;
   private float salario;
   Scanner in = new Scanner(System.in);
    public Colaborador(String nome, float salario) {
        this.nome = nome;
        this.salario = salario;
        almento();
        reajuste();
    }
   
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public float almento() {
        if(this.salario<=280){
            System.out.println("20&");
            System.out.println(this.salario*0.2);
        }else if(this.salario>280&&this.salario<=700){
            this.salario = (this.salario*1.15f);
            System.out.println(this.salario*0.15);
            System.out.println("15%");
        }else if(this.salario>700&&this.salario<=1500){
            System.out.println("10%");
             System.out.println(this.salario*0.1);
            this.salario = this.salario*1.10f;
        }else if(this.salario>1500){
            System.out.println("5%");
            System.out.println(this.salario*0.05f);
            this.salario = this.salario*1.05f;
        }
        System.out.println(this.salario);
        return this.salario;
       
    }

    @Override
    public float reajuste() {
        System.out.println("salario: R$"+this.salario);
        System.out.println("IR(5%): R$"+this.salario*0.05f);
        System.out.println("INSS (10%): R$"+this.salario*0.1f);
        System.out.println("FGTS (11%): R$"+this.salario*0.11f);
        
        float salario = this.salario;
        this.salario = this.salario*0.95f;
        this.salario = this.salario*0.90f;
        this.salario = this.salario*0.89f;
        System.out.println("total de deescontos: RS"+(this.salario-salario));
        System.out.println("salario liquido: R$"+this.salario);
        return this.salario;
    }
    public void triangulo(){
        int a,b,c;
         System.out.println("lado a");
        a = in.nextInt();
        System.out.println("lado b");
        b = in.nextInt();
        System.out.println("lado c");
        c= in.nextInt();
       if(a+b>c&&a+c>b&&c+b>a){
           System.out.println("forma triangulo");
           if(a==b&&a==c){
               System.out.println("equilatero");
           }else if(a==b||a==c||c==b){
               System.out.println("isoceles");
           }else if(a!=b&&a!=c&&c!=b){
               System.out.println("escaleno");
           }
       }
    }
   
}
