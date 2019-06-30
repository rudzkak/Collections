package sdaCollections.algorytmySortowania;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSortZadanie {

    public void bubbleSortLista(List<Integer> lista){

        int rozmiar = lista.size();

        if(lista ==null || rozmiar ==0){
            return;
        }

        for(int i =0; i<rozmiar; i++){
            boolean zmiana = false;
            for(int j=0; j<rozmiar-1; j++){
                if(lista.get(j)< lista.get(j+1)){
                        int temp = lista.get(j);
                        lista.set(j,lista.get(j+1));
                        lista.set(j+1, temp);
                        zmiana = true;
                }
            }
            if(!zmiana){
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSortZadanie bubbleSortZadanie = new BubbleSortZadanie();
        List<Integer> lista = new ArrayList<>();
        Collections.addAll(lista, 2,12,4,1,6,3);
        bubbleSortZadanie.bubbleSortLista(lista);
        System.out.println(lista);
    }

}
