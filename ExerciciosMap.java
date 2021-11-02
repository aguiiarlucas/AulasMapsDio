package br.com.one.innovation.dio.Map;


/*
Dada a população estimada de alguns estados do NE brasileiro, faça:

Estado = PE - População = 9.616.621
Estado = AL - População = 3.351.543
Estado = CE - População = 9.187.103
Estado = RN - População = 3.534.265


-Exiba a média da população deste dicionário de estados;
-Remova os estados com a população menor que 4.000.000;
-Apague o dicionário de estados;
-Confira se o dicionário está vazio.

 */


import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class ExerciciosMap {

    public static void main(String[] args) {

        System.out.println("-\nCrie um dicionário e relacione os estados e suas populações;");
        Map<String,Integer>estadosPopulacao = new HashMap<>(){{
            put("PE",99616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
        }};
        System.out.println(estadosPopulacao);

        System.out.println("-\nSubstitua a população do estado do RN por 3.534.165;");
        estadosPopulacao.put("RN",3534165);
        System.out.println(estadosPopulacao);

        System.out.println("-\nConfira se o estado da Paraíba (PB) tucson está no dicionário, caso não, adicione " +
                "PB - 4.039.277: ");
        estadosPopulacao.put("PB", 4039277);
        System.out.println(estadosPopulacao);

        System.out.println("-\nExiba a população PE;");
        System.out.println(estadosPopulacao.get("PE"));

        System.out.println("-\nExiba todos os estados e suas populações na ordem que foi informado;");
        Map<String,Integer>estadosPopulacao2 = new LinkedHashMap<>(){{
            put("PE",99616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
        }};
        System.out.println(estadosPopulacao2);

        System.out.println("-\nExiba todos os estados e suas populações na ordem alfabetica;");
        Map<String,Integer>estadosPopulacao3 = new TreeMap<>(estadosPopulacao);
        System.out.println(estadosPopulacao3);

        Collection<Integer>populacao = estadosPopulacao.values();
        String  maiorPopulacao = "";
        String  menorPopulacao = "";

        for (Map.Entry<String,Integer> entry : estadosPopulacao.entrySet()) {
            if (entry.getValue().equals(Collections.max(populacao))) maiorPopulacao = entry.getKey();
            if (entry.getValue().equals(Collections.min(populacao))) menorPopulacao = entry.getKey();
        }

        System.out.printf("Exiba o estado com o menor população (%s) e seu respectivo valor (%d)\n",
        menorPopulacao,Collections.min(populacao));
        System.out.printf("Exiba o estado com o maior população (%s) e seu respectivo valor (%d)\n",
         maiorPopulacao,Collections.max(populacao));



        int soma = 0;
        Iterator<Integer> iterator = estadosPopulacao.values().iterator();
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("-\n Exiba a soma da população desses estados: "+soma);

        System.out.println("-\n Exiba a media da populacao "+ (soma/estadosPopulacao.size()));

        System.out.println("Remova os estados com a população menor que 4.000.000: ");
        estadosPopulacao.values().removeIf(integer -> integer<=4000000);
        System.out.println(estadosPopulacao);

        System.out.println("Apague o dicionario de estados com suas respectivas populações estimadas: ");
        estadosPopulacao.clear();
        System.out.println(estadosPopulacao);
        System.out.println("Confira se a Lista está vazia:: "+ estadosPopulacao.isEmpty());





























































    }
}
