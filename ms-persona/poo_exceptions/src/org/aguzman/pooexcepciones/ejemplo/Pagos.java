package org.aguzman.pooexcepciones.ejemplo;

public class Pagos {



    public String retirarDinero(int sal,int retir) throws SaldoInsuficienteException{

        if (sal<retir){

            throw new SaldoInsuficienteException("no se puede retirar el monto del retiro es mayor que el saldo");
        }

        return "Operacion exitosa";
    }
}
