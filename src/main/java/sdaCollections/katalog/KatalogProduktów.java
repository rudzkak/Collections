package sdaCollections.katalog;

import sdaCollections.Produkt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static sdaCollections.Produkt.BY_WAGA;

public class KatalogProduktów implements Iterable{


    public SortedSet<Produkt> setProduktów = new TreeSet<>(BY_WAGA);
    public List<Produkt> listaProduktów = new ArrayList<>();

    public void zapewnanianyPrzez(Dostawca dostawca){
        listaProduktów = dostawca.getListaProduktów();
        setProduktów.addAll(listaProduktów);
    }

    public Set<Produkt> produktyMalyVan(){
        Produkt najciezszyWMałymVanie = najciezszyWMałymVanie();
        return setProduktów.headSet(najciezszyWMałymVanie);
    }

    public Set<Produkt> produktyDuzyVan(){
        return setProduktów.tailSet(najciezszyWMałymVanie());
    }


    public Produkt najciezszyWMałymVanie(){
        for(Produkt produkt : setProduktów){
            if(produkt.getWaga() > 10){
                return produkt;
            }
        }
        return setProduktów.last();
    }

    @Override
    public Iterator iterator() {
        return setProduktów.iterator();
    }
}
