package sdaCollections.algorytmyKolekcje;

import sdaCollections.Produkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usprawnienia {

    public static void main(String[] args) {

        Produkt produkt1 = new Produkt("drzwi", 40);
        Produkt produkt2 = new Produkt("okno", 20);
        Produkt produkt3 = new Produkt("panel", 5);

        List<Produkt> listaProduktów = new ArrayList<>();

        Collections.addAll(listaProduktów,produkt1, produkt2, produkt3);
        System.out.println(listaProduktów);

        Produkt min = Collections.min(listaProduktów, Produkt.BY_WAGA);
        System.out.println(min);

        Produkt max = Collections.max(listaProduktów, Produkt.BY_WAGA);
        System.out.println(max);

    }
}
