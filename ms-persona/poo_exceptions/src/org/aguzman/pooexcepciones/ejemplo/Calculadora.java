package org.aguzman.pooexcepciones.ejemplo;

public class Calculadora {

    public double dividir (int numerador, int divisor) throws DivisionPorCeroException {

        if (divisor==0){
            throw new DivisionPorCeroException("No se puede dividir por cero");
        }

        return numerador/(double)divisor;
    }
    public double dividir (String num,String div) throws DivisionPorCeroException, FormatNumberException {


        try {
            int numerador= Integer.parseInt(num);
            int divisor = Integer.parseInt(div);
            return this.dividir(numerador,divisor);

        }catch (NumberFormatException nf){

            throw new FormatNumberException("debe ingresar un numero");
        }

    }
}

