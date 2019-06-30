package sdaCollections.mapy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PrzeglądProduktówPorównanie {

    private static final int ITERACJE = 5;
    private static final int LICZBA_PRODUKTÓW = 50000;

    private static List<Produkt> produkty = generujProdukty();

    private static List<Produkt> generujProdukty() {

        final List<Produkt> produkty = new ArrayList<>();
        final Random generatorWagi = new Random();

        for (int i = 0; i < LICZBA_PRODUKTÓW; i++) {
            produkty.add(new Produkt(i, "Produkt " + i,
                    generatorWagi.nextInt(10)));
        }

        Collections.shuffle(produkty);
        Collections.shuffle(produkty);
        Collections.shuffle(produkty);

        return produkty;
    }

    public static void uruchomPrzegląd(final PrzeglądProduktów przeglądProduktów) {
        for (int i = 0; i < ITERACJE; i++){
            final long czasStart = System.currentTimeMillis();

            for(Produkt produkt : produkty){
                przeglądProduktów.dodajProdukt(produkt);
            }

            for(Produkt produkt : produkty){
                final Produkt wynik = przeglądProduktów.znajdzPoId(produkt.getId());
                if(wynik!= produkt){
                    throw new IllegalStateException("Porównanie produktów zwróciło " +
                            "zły wynik dla: " + produkt);
                }
            }
            przeglądProduktów.wyczyść();

            System.out.println(System.currentTimeMillis() - czasStart + "ms");
        }
    }

    public static void main(String[] args) {
        uruchomPrzegląd(new PrzeglądProduktówLista());
        uruchomPrzegląd(new PrzeglądProduktówMapa());
    }
}
