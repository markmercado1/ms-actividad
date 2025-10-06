package org.aguzman.pooexcepciones.ejemplo;

public class PagosEjemplo {

    public static void main(String[] args) {
        Pagos pagos=new Pagos();

        try {

            int saldo=10;
            int retiro=20;
            String operacion=pagos.retirarDinero(saldo,retiro);
            System.out.println(operacion);
        }catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

    }
}
