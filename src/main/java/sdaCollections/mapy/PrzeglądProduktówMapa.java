package sdaCollections.mapy;

import java.util.HashMap;
import java.util.Map;

public class PrzeglądProduktówMapa implements PrzeglądProduktów {

    Map<Integer,Produkt> idDoProduktu = new HashMap<>();
    @Override
    public void dodajProdukt(Produkt produktDoDodania) {
        if(idDoProduktu.containsKey(produktDoDodania.getId())){
            throw new IllegalArgumentException("Nie można " +
                    "dodać produktu " + produktDoDodania + " bo to duplikat");
        }
        idDoProduktu.put(produktDoDodania.getId(),produktDoDodania);
    }

    @Override
    public Produkt znajdzPoId(int id) {

        return idDoProduktu.get(id);
    }

    @Override
    public void wyczyść() {
        idDoProduktu.clear();
    }
}
