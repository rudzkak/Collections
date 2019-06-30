package sdaCollections.mapy.hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SiećHoteli {

    private Map<String, Hotel> siećHoteli = new HashMap<>();

    public List<Pokój> wolnePokojeWMieście(String miasto){
        List<Pokój> lista = new ArrayList<>();
        for(Map.Entry<String, Hotel> wpisWSieci : siećHoteli.entrySet()){
            if(wpisWSieci.getValue().getMiasto().equals(miasto)) {
                for (Map.Entry<Pokój, Gość> wpisWHotelu : wpisWSieci.getValue()
                        .getMapaPokoi().entrySet()){
                    if(wpisWHotelu.getValue().equals(Hotel.DEFAULT)){
                        lista.add(wpisWHotelu.getKey());
                    }
                }
            }
        }
        return lista;
    }

    public int liczbaGościWSieciHoteli(){
        int licznik = 0;
        for(Map.Entry<String, Hotel> wpisWSieci: siećHoteli.entrySet()){
            for(Map.Entry<Pokój, Gość> wpisWHotelu : wpisWSieci.getValue()
                    .getMapaPokoi().entrySet()){
                if(!wpisWHotelu.getValue().equals(Hotel.DEFAULT)){
                    licznik++;
                }
            }
        }
        return licznik;
    }
}
