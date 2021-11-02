package br.com.one.innovation.dio.Map;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {

        /*Dados os modelos dos carros e seus respectivos consumo na estrada , faça:

        modelo = gol - consumo = 14,4 km
        modelo = uno - consuimo = 15,6km
        modelo = mobi - consumo = 16,1km
        modelo = kh20 - consumo 14,5km
        modelo = kwid - consumo = 15,6km
         */

        System.out.println("\tCrie um dicionário que relacione os modelos e seus respectivos consumos");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.1);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares);

        System.out.println("\t\nSubstitua o consumo do gol por 15,2km");
        carrosPopulares.put("gol",15.2);
        System.out.println(carrosPopulares);

        System.out.println("\t\nConfira se o modelo TUCSON está no dicionario");
        System.out.println(carrosPopulares.containsKey("tuscon"));

        System.out.println("\t\n Exiba o consumo do uno");
        System.out.println(carrosPopulares.get("uno"));

        System.out.println("\t\n Exiba os modelos:");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);


        System.out.println("\t\nExiba o consumo dos carros");
        Collection<Double> values = carrosPopulares.values();
        System.out.println(values);

        System.out.println("\nExiba o modelo mais economico e seu consumo");

        Double consumoEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloEficiente = "";

        for (Map.Entry<String, Double> entry : entries){
            if (entry.getValue().equals(consumoEficiente))modeloEficiente = entry.getKey() ;

        }
        System.out.print("\nModelo mais efieciente: "+modeloEficiente+ " - "+consumoEficiente  );

        System.out.println("Exiba o modelo mais economico e seu consumo");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
         for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()){
             if (entry.getValue().equals(consumoMenosEficiente))modeloEficiente = entry.getKey()  ;

         }
        System.out.println("\nModelo menos eficiente:"+modeloEficiente+ " - " + consumoMenosEficiente);

        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            soma+= iterator.next();
        }
        System.out.println("Soma: "+ soma);

        System.out.println("\nExiba a media do consumo:" + (soma/carrosPopulares.size()));

        System.out.println("Remova os modelos com o consumo igual a 15.6");
        carrosPopulares.values().removeIf(aDouble -> aDouble.equals(15.6));
        System.out.println(carrosPopulares);

        System.out.println("Exiba todas os carros em ordem em que foram informado");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.1);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1);

        System.out.println("Exiba o dicionario ordernado pelo modelo: ");
        TreeMap<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);

        System.out.println("Apague o dicionario de carros");
        carrosPopulares.clear();

        System.out.println("Confira se esta vazia: "+ true);






    }

    }
