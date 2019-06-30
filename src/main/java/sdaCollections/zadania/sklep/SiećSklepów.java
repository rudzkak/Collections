package sdaCollections.zadania.sklep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SiećSklepów {

    private Map<String , Map<GatunekProduktu, List<Produkt>>> mapaSieci =
            new HashMap<>();

    public void dodajDoSieci(Sklep sklep){
        mapaSieci.put(sklep.getMiasto(),sklep.getMapaSklepu());
    }

    public List<Produkt> znajdzProduktyKonkretnegoGatunkuIKonkretnegoProducentaWDanymMiescie(GatunekProduktu gatunekProduktu, Producent producent, String miasto){
        List<Produkt> lista = new ArrayList<>();
        if(mapaSieci.containsKey(miasto)){
            for(Map.Entry<String, Map<GatunekProduktu, List<Produkt>>> wpis: mapaSieci.entrySet()){
                if(wpis.getKey().equals(miasto)){
                    if(wpis.getValue().containsKey(gatunekProduktu)){
                        for(Map.Entry<GatunekProduktu, List<Produkt>> wpisWMapie : wpis.getValue().entrySet()){
                            if(wpisWMapie.getKey().equals(gatunekProduktu)){
                                for(Produkt produkt : wpisWMapie.getValue()){
                                    lista.add(produkt);
                                }
                            }
                        }
                    }
                }
            }
        }
        return lista;
    }

}
