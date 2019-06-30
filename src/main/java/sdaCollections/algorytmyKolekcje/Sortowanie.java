package sdaCollections.algorytmyKolekcje;

import sdaCollections.Produkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sortowanie {

    public static void main(String[] args) {


        List<Produkt> produkty = new ArrayList<>();

        produkty.add(new Produkt("drzwi", 40));
        produkty.add(new Produkt("okno", 20));
        produkty.add(new Produkt("panel", 5));

        produkty.forEach(System.out::println);
        System.out.println("----");

        //Collections.sort(produkty, Produkt.BY_WAGA);
        produkty.sort(Produkt.BY_WAGA);
        produkty.forEach(System.out::println);
        System.out.println("----");

        //Collections.sort(produkty, Produkt.BY_NAME);
        produkty.sort(Produkt.BY_NAME);
        produkty.forEach(System.out::println);
        System.out.println("----");
    }
}
