package sdaCollections.algorytmySortowania;

public class QuickSort {

    private int tablica[];
    private int rozmiar;

    public void sort(int tablica[]){
        if(tablica == null || tablica.length==0){
            return;
        }

        this.tablica = tablica;
        this.rozmiar = tablica.length;

        quicksort(0, rozmiar -1);
    }

    public void quicksort(int mniejszyIndeks, int wiekszyIndeks){

        int i = mniejszyIndeks;
        int j = wiekszyIndeks;

        //liczymy pivot

        int pivot = tablica[mniejszyIndeks + (wiekszyIndeks-mniejszyIndeks)/2];

        // dzielimy na dwie tablice

        while (i<=j) {
            // w każdej iteracji wyczukujemy
            // liczbe z lewej strony, ktora wieksza od pivota i
            // liczbe z prawej strony ktora jest mniejsza od pivota
            // i zamieniamy je miejscami

            while (tablica[i] < pivot) {
                i++;
            }
            while (tablica[j] > pivot) {
                j--;
            }
            if (i <= j) {
                zamienLiczby(i, j);
                i++;
                j--;
            }
        }
        // wywołanie rekursywne
        if(mniejszyIndeks <j){
            quicksort(mniejszyIndeks,j);
        }
        if(i< wiekszyIndeks){
            quicksort(i, wiekszyIndeks);
        }

    }

    public void zamienLiczby(int i, int j) {
        int temp = tablica[i];
        tablica[i] = tablica[j];
        tablica[j]= temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int tablica[] = {101,8,1,66,2,76,4};
        quickSort.sort(tablica);
        for(int i : tablica){
            System.out.println(i);
        }
    }
}
