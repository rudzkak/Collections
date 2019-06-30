package sdaCollections.mapy;

import java.util.ArrayList;
import java.util.List;

public class PrzeglądProduktówLista implements PrzeglądProduktów {

    List<Produkt> listaProduktów = new ArrayList<>();

    @Override
    public void dodajProdukt(Produkt produktDoDodania) {
        for (Produkt produkt : listaProduktów) {
            if (produkt.getId() == produktDoDodania.getId()) {
                throw new IllegalArgumentException("Nie można " +
                        "dodać produktu " + produktDoDodania + " bo to duplikat");
            }
        }
        listaProduktów.add(produktDoDodania);
    }

    @Override
    public Produkt znajdzPoId(int id) {
        for(Produkt produkt : listaProduktów){
            if(produkt.getId() == id){
                return produkt;
            }
        }
        return null;
    }

    @Override
    public void wyczyść() {
        listaProduktów.clear();
    }
}
