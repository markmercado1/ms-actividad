package org.aguzman.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExceptions {
    public static void main(String[] args) {
        Calculadora calculadora=new Calculadora();
        String valor= JOptionPane.showInputDialog("Ingrese un numero");
        double division;
        int divisor;


        try {
            divisor=Integer.parseInt(valor);
            division=calculadora.dividir(10,divisor);
            double division2=calculadora.dividir("10","5");
            System.out.println("division = " + division);


        }catch (DivisionPorCeroException e){
            System.out.println("Capturamos al excepcion en tiempo de ejecucion:" + e.getMessage());
        }catch (NumberFormatException nf){
            System.out.println("Ingrese un numero no un puto string"+ nf.getMessage());
        }catch (FormatNumberException e) {
            System.out.println("Se detecto una excepcion intente de nuevo"+e.getMessage());
        }

        System.out.println("continuamos con el flujo de nuestra aplicacion ");

    }


}
