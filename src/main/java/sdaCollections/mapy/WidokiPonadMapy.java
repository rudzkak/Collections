package sdaCollections.mapy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WidokiPonadMapy {

    public static void main(String[] args) {

        Produkt drzwi = new Produkt(1, "drzwi dębowe", 25);
        Produkt okno = new Produkt(2, "okno dębowe", 30);
        Produkt panel = new Produkt(3, "panel dębowy", 5);

        Map<Integer, Produkt> idDoProduktu = new HashMap<>();

        idDoProduktu.put(drzwi.getId(), drzwi);
        idDoProduktu.put(okno.getId(), okno);
        idDoProduktu.put(panel.getId(), panel);

        System.out.println(idDoProduktu);
        System.out.println();

        Set<Integer> ids = idDoProduktu.keySet();
        System.out.println(ids);

        ids.remove(1);
        System.out.println(ids);
        System.out.println(idDoProduktu);

        //ids.add(4); <- tutaj poleci błąd

//        Set<Integer> nowySet = new HashSet<>();
//        nowySet.addAll(ids);
//        nowySet.add(4);
//        System.out.println(nowySet);

        Set<Map.Entry<Integer, Produkt>> wpisy = idDoProduktu.entrySet();
        for (Map.Entry<Integer, Produkt> wpis : wpisy) {
            System.out.println(wpis.getKey() + "->" + wpis.getValue());
        }

        for (Map.Entry<Integer, Produkt> wpis : wpisy) {
            wpis.setValue(drzwi);
            System.out.println(wpis.getKey() + "->" + wpis.getValue());
        }
    }
}
