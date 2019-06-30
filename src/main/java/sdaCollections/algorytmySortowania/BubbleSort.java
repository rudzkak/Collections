package sdaCollections.algorytmySortowania;

public class BubbleSort {

    private int [] tablica = {8,3,6,5};


    public void bubbleSort(int tablica[]){

        int rozmiar = tablica.length;

        if(tablica == null || rozmiar == 0){
            return;
        }

        for(int i=0; i<rozmiar; i++){
            for(int j=0; j<rozmiar-1; j++){
                if(tablica[j] > tablica[j+1]){
                    int temp = tablica[j];
                    tablica[j] = tablica[j+1];
                    tablica[j+1] = temp;
                }
            }
        }
    }

    public void bubbleSortWydajniejszaWersja(int tablica[]){

        int rozmiar = tablica.length;

        if(tablica==null || rozmiar ==0){
            return;
        }

        for(int i=0; i<rozmiar; i++){
            boolean zamiana = false;
            for(int j=0; j<rozmiar-1; j++){
                if(tablica[j]> tablica[j+1]){
                    int temp = tablica[j];
                    tablica[j]= tablica[j+1];
                    tablica[j+1] = temp;
                    zamiana =true;
                }
            }
            if(!zamiana){
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSortWydajniejszaWersja(bubbleSort.tablica);

        for(int i = 0; i< bubbleSort.tablica.length; i++){
            System.out.println(bubbleSort.tablica[i]);
        }
    }
}
