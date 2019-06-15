package sdaCollections.zadania.pralnia;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Pralnia {

    private List<Usługa> listaUsług = new ArrayList<>();
    private Queue<Usługa> kolejkaUsług = new PriorityQueue<>();

    public void dodajUsługe(Usługa usługa) {
        listaUsług.add(usługa);
        kolejkaUsług.offer(usługa);
    }

    public void wykonajUsługe(Usługa usługa) {
        if (listaUsług.contains(usługa)) {
            listaUsług.remove(usługa);
        }
        if (kolejkaUsług.contains(usługa)) {
            kolejkaUsług.remove(usługa);
        }
    }

    public List<Usługa> usługiKonkretnegoKlienta(Klient klient) {
        List<Usługa> lista = new ArrayList<>();
        for (Usługa usługa : listaUsług) {
            if (usługa.getKlient().equals(klient)) {
                lista.add(usługa);
            }
        }
        return lista;
    }

    public List<Usługa> usługiKonkretnegoKlientaJava8(Klient klient) {
        List<Usługa> lista = listaUsług.stream()
                .filter(usługa -> usługa.getKlient().equals(klient))
                .collect(Collectors.toList());
        return lista;
    }

    public List<Klient> listaKlientówJava8() {
        return listaUsług.stream()// Stream<Usługa>
                .map(Usługa::getKlient) //Stream<Klient>
                .collect(Collectors.toList());
    }

    public List<Ubranie> ubraniaZBawełny() {
        return listaUsług.stream() //Stream<Usługa>
                .map(usługa -> usługa.getUbranie()) // Stream<Ubranie>
                .filter(ubranie -> ubranie.getMateriał().equals(Materiał.BAWEŁNA))
                .collect(Collectors.toList());
    }

    public List<Usługa> usługiZKonretnymMateriałem(Materiał materiał) {
        List<Usługa> lista = new ArrayList<>();
        for (Usługa usługa : listaUsług) {
            if (usługa.getUbranie().getMateriał().equals(materiał)) {
                lista.add(usługa);
            }
        }
        return lista;
    }

    public List<Usługa> usługiZKonretnymMateriałemJava8(Materiał materiał) {
        return listaUsług.stream()
                .filter(usługa -> usługa.getUbranie().getMateriał().equals(materiał))
                .collect(Collectors.toList());
    }

    public long liczbaUsługZKonretnymMateriałemJava8(Materiał materiał) {
        return listaUsług.stream()
                .filter(usługa -> usługa.getUbranie().getMateriał().equals(materiał))
                .count();
    }

    public void wykonajWszystkieUsługi(){
        while (kolejkaUsług.peek() != null){
            System.out.println("Usługa: " + kolejkaUsług.peek() + "została wykonana");
            wykonajUsługe(kolejkaUsług.peek());
        }
    }

    public static void main(String[] args) {
        Klient janNowak = new Klient("Jan", "Nowak");
        Klient elaJanusz = new Klient("Ela", "Janusz");
        Klient hieronimZet = new Klient("Hieronim", "Zet");
        Klient adeljadaPe = new Klient("Adelajda", "Pe");

        Ubranie spodnieJana = new Ubranie(Materiał.LEN, "spodnie", "biel");
        Ubranie marynarkaJana = new Ubranie(Materiał.WEŁNA, "marynarka", "czerń");
        Ubranie koszulaJana = new Ubranie(Materiał.BAWEŁNA, "koszula", "zieleń");
        Ubranie spodnieEli = new Ubranie(Materiał.WEŁNA, "spodnie", "biel");
        Ubranie marynarkaHieronima = new Ubranie(Materiał.WEŁNA, "marynarka", "beż");
        Ubranie koszulaAdelajdy = new Ubranie(Materiał.BAWEŁNA, "koszula", "zieleń");

        Usługa usługa1 = new Usługa(janNowak, spodnieJana);
        Usługa usługa2 = new Usługa(janNowak, marynarkaJana);
        Usługa usługa3 = new Usługa(janNowak, koszulaJana);
        Usługa usługa4 = new Usługa(elaJanusz, spodnieEli);
        Usługa usługa5 = new Usługa(hieronimZet, marynarkaHieronima);
        Usługa usługa6 = new Usługa(adeljadaPe, koszulaAdelajdy);

        Pralnia pralnia = new Pralnia();

        pralnia.dodajUsługe(usługa1);
        pralnia.dodajUsługe(usługa2);
        pralnia.dodajUsługe(usługa3);
        pralnia.dodajUsługe(usługa4);
        pralnia.dodajUsługe(usługa5);
        pralnia.dodajUsługe(usługa6);

        System.out.println("I test: lista" + pralnia.listaUsług);
        System.out.println("I test: kolejka" + pralnia.kolejkaUsług);

        pralnia.wykonajUsługe(usługa1);

        System.out.println("II test: lista " + pralnia.listaUsług);
        System.out.println("II test: kolejka " + pralnia.kolejkaUsług);

        System.out.println("III test: usługi klienta " + pralnia.usługiKonkretnegoKlienta(janNowak));
        System.out.println();
        System.out.println("IV test: usługi klienta " + pralnia.usługiKonkretnegoKlientaJava8(hieronimZet));
        System.out.println();
        System.out.println("V test: klienci " + pralnia.listaKlientówJava8());
        System.out.println();
        System.out.println("VI test: ubrania z lnu " + pralnia.ubraniaZBawełny());
        System.out.println();
        System.out.println("VII test: usługi z konkretnym materiałem " +
                pralnia.usługiZKonretnymMateriałem(Materiał.WEŁNA));
        System.out.println();
        System.out.println("VIII test: usługi z konkretnym materiałem " +
                pralnia.usługiZKonretnymMateriałemJava8(Materiał.WEŁNA));
        System.out.println();
        System.out.println("IX test: liczba usług z konkretnym materiałem " +
                pralnia.liczbaUsługZKonretnymMateriałemJava8(Materiał.BAWEŁNA));
        System.out.println();
        System.out.println("X test: " );
        pralnia.wykonajWszystkieUsługi();
    }

}
