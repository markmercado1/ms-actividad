package org.mark.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashetBuscarDuplicado {
    public static void main(String[] args) {
        String [] peces = {"Corvina","Salmon","Salmon","Jurel","Salmon","Salmon"};
        Set <String> unicos=new HashSet<>();
        Set <String> duplicados = new HashSet<>();

        

        for(String pez : peces){

            if (!unicos.add(pez)){
                duplicados.add(pez);
            }
        }
        System.out.println(unicos.size());
        unicos.removeAll(duplicados);

        System.out.println("duplicados: "+duplicados);

        System.out.println("unicos: "+ unicos);

    }

}
