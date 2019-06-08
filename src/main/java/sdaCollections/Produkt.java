package sdaCollections;

import java.util.Comparator;

public class Produkt {

    private final String nazwa;
    private final int waga;

    public Produkt(String nazwa, int waga){
        this.nazwa = nazwa;
        this.waga = waga;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getWaga() {
        return waga;
    }


    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", waga=" + waga +
                '}';
    }

    public static final Comparator<Produkt> BY_WAGA = new Comparator<Produkt>() {
        @Override
        public int compare(Produkt p1, Produkt p2) {
            return Integer.compare(p1.getWaga(), p2.getWaga());
        }
    };
}
