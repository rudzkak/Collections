package sdaCollections.wysyłka;

import sdaCollections.Produkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Poczta implements Iterable<Produkt> {


    public static final int PRODUKT_NIE_ISTNIEJE = -1;
    public static final int MINI_VAN_MAX_WAGA = 20;

    private final List<Produkt> produkty = new ArrayList<>();
    private List<Produkt> malyVanProdukty;
    private List<Produkt> duzyVanProdukty;

    public List<Produkt> getMalyVanProdukty(){
        return malyVanProdukty;
    }

    public List<Produkt> getDuzyVanProdukty() {
        return duzyVanProdukty;
    }

    public void dodaj(Produkt produkt) {
        produkty.add(produkt);
    }

    public void zamień(Produkt staryProdukt, Produkt nowyProdukt) {
        int indeks = produkty.indexOf(staryProdukt);

        if (indeks != PRODUKT_NIE_ISTNIEJE) {
            produkty.set(indeks, nowyProdukt);
        } else {
            System.out.println("\n" + "Nie istnieje produkt o podanym indeksie");
        }
    }

    public void przygotujPrzesyłke() {
        // sort wg wagi
        Collections.sort(produkty, Produkt.BY_WAGA);
        // znajdz indeks produktu, ktory jako pierwszy musi byc w duzym vanie
        int indeks = znajdzIndeksPodziału();
        malyVanProdukty = produkty.subList(0, indeks);
        duzyVanProdukty = produkty.subList(indeks, produkty.size());
    }

    public int znajdzIndeksPodziału() {
        for (int i = 0; i < produkty.size(); i++) {
            if (produkty.get(i).getWaga() > MINI_VAN_MAX_WAGA) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public Iterator<Produkt> iterator() {

        return produkty.iterator();
    }

    @Override
    public String toString() {
        return produkty.toString();
    }
}
