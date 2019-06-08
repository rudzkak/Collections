package sdaCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Kolekcje {

    public static void main(String[] args) {
        Produkt drzwi = new Produkt("drzwi dębowe", 40);
        Produkt okno = new Produkt("okno dębowe", 30);
        Produkt panel = new Produkt("panel dębowy", 5);
        Produkt deska = new Produkt("deska sosnowa", 5);

        Collection<Produkt> produkty = new ArrayList<>();
        produkty.add(drzwi);
        produkty.add(okno);
        produkty.add(panel);
        produkty.add(deska);

        System.out.println(produkty);

        final Iterator<Produkt> iterator  = produkty.iterator();
//
//        while (iterator.hasNext()){
//            Produkt produkt = iterator.next();
//            if(produkt.getWaga() > 20) {
//                System.out.println(produkt);
//            } else {
//                iterator.remove();
//            }
//        }
//
        for(Produkt produkt : produkty){
            if(produkt.getWaga() > 20) {
                System.out.println(produkt);
            } else {
                produkty.clear();
            }
        }

        System.out.println(produkty.size());
        System.out.println(produkty.isEmpty());
        System.out.println(produkty.contains(panel));
        produkty.remove(okno);
        System.out.println(produkty.contains(okno));

        List<Produkt> listaPomocnicza = new ArrayList<>();
        listaPomocnicza.add(drzwi);
        listaPomocnicza.add(okno);

        produkty.addAll(listaPomocnicza);
        System.out.println(produkty);
        produkty.removeAll(listaPomocnicza);
        System.out.println(produkty);

    }
}
