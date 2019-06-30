package sdaCollections.mapy;

import java.util.HashMap;
import java.util.Map;

public class Java8Nowości {

    public static void main(String[] args) {


        Produkt drzwi = new Produkt(1, "drzwi dębowe", 25);
        Produkt okno = new Produkt(2, "okno dębowe", 30);
        Produkt panel = new Produkt(3, "panel dębowy", 5);

        Produkt produktD = new Produkt(-1, "domyślny", 100);

        Map<Integer, Produkt> idDoProduktu = new HashMap<>();
        idDoProduktu.put(drzwi.getId(), drzwi);
        idDoProduktu.put(okno.getId(), okno);
        idDoProduktu.put(panel.getId(),panel);


        Produkt produkt = idDoProduktu.get(10);
        System.out.println(produkt);

        Produkt produktDomyslny = idDoProduktu.getOrDefault(10, produktD);
        System.out.println(produktDomyslny);

        Produkt produktDomyslnyIstniejący = idDoProduktu.getOrDefault(3,produktD);
        System.out.println(produktDomyslnyIstniejący);

        System.out.println(idDoProduktu);

        System.out.println();

        Produkt wynik = idDoProduktu.replace(1,
                new Produkt(1,"duże drzwi", 30));

        System.out.println(wynik);
        System.out.println(idDoProduktu.get(1));
        System.out.println();

        Produkt nieobecny = idDoProduktu.replace(4,
                new Produkt(1,"duże drzwi", 30));
        System.out.println(nieobecny);
        System.out.println(idDoProduktu.get(4));
        System.out.println();

        idDoProduktu.replaceAll((id, staryProdukt)->
                new Produkt(staryProdukt.getId(), staryProdukt.getNazwa(),
                        staryProdukt.getWaga()+10));
        System.out.println(idDoProduktu);

        Produkt nieobecny2 = idDoProduktu.computeIfAbsent(10, (id)->
                new Produkt(10, "nowy produkt", 10));

        System.out.println(nieobecny2);
        System.out.println(idDoProduktu.get(10));

        System.out.println();

        Produkt obecny = idDoProduktu.computeIfAbsent(2, (id) ->
                new Produkt(2, "nowy produkt", 10));
        System.out.println(obecny);
        System.out.println(idDoProduktu.get(2));

        idDoProduktu.forEach((klucz, wartosc)->
                System.out.println(klucz + "->" + wartosc));

    }
}
