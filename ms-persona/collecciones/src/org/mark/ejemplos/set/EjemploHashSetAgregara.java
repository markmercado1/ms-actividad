package org.mark.ejemplos.set;

import java.util.*;

public class EjemploHashSetAgregara {
    public static void main(String[] args) {
        Set<String> hs =new HashSet<>();
        hs.add("tres");
        hs.add("cinco");
        hs.add("uno");
        hs.add("cuatro");
        hs.add("dos");

        List<String> lista = new ArrayList<>(hs);
        Collections.sort(lista);
        System.out.println("hs = " + hs);
        hs.add("tres");
        System.out.println("hs = " + lista);

        Set<String> hash = new HashSet<>();
        Set<String> linked = new LinkedHashSet<>();
        Set<String> tree = new TreeSet<>();

        for (String s : List.of("tres", "cinco", "uno", "cuatro", "dos")) {
            hash.add(s);
            linked.add(s);
            tree.add(s);
        }

        System.out.println("HashSet:      " + hash);
        System.out.println("LinkedHashSet:" + linked);
        System.out.println("TreeSet:      " + tree);
    }
}
