package sdaCollections.biblioteka;

public class BibliotekaTest {

    public final static int BRAK_KSIĄŻKI_NA_PÓŁCE = -1;

    Książka wPustyniIWPuszczy = new Książka( "W pustyni i w puszczy","Henryk Sienkiewicz");
    Książka harryPotter = new Książka("Harry Potter", "J.R.R. Rowling");
    Książka panTadeusz = new Książka("Pan Tadeusz", "Adam Mickiewicz");
    Książka ogniemIMieczem = new Książka("Henryk Sienkiewicz", "Ogniem i mieczem");
    Książka panWolodyjowski = new Książka("Pan Wołodyjowski", "Henryk Sienkiewicz");
    Książka mojaKsiażka = new Książka("Ja", "Karolina Rudzka");

    Półka półka1 = new Półka(1);
    Półka półka2 = new Półka(2);
    Półka półka3 = new Półka(3);
    Półka półka4 = new Półka(4);

    private Biblioteka biblioteka = new Biblioteka();

    public void dodanieNaPółkę(){
        biblioteka.dodajNaPółkę(półka1,wPustyniIWPuszczy);
        biblioteka.dodajNaPółkę(półka2, harryPotter);
        biblioteka.dodajNaPółkę(półka3, panTadeusz);
        biblioteka.dodajNaPółkę(półka2, ogniemIMieczem);
        biblioteka.dodajNaPółkę(półka1, panWolodyjowski);
        biblioteka.dodajNaPółkę(półka3, mojaKsiażka);
        biblioteka.dodajNaPółkę(półka4, wPustyniIWPuszczy);
        biblioteka.dodajNaPółkę(półka4, harryPotter);
        biblioteka.dodajNaPółkę(półka4, panTadeusz);
        biblioteka.dodajNaPółkę(półka4, ogniemIMieczem);
        biblioteka.dodajNaPółkę(półka4, panWolodyjowski);
        biblioteka.dodajNaPółkę(półka4, mojaKsiażka);

        System.out.println("I test: " + półka1 + "\n"+ półka2 + "\n" + półka3 + "\n" + półka4);
    }

    public void wypiszZawartość(){
        System.out.println("II test: ");
        biblioteka.wypiszZawartość(półka3);
    }

    public void przełóżKsiążke(){
        System.out.println("III test: ");
        biblioteka.przełóżKsiążkę(półka2,harryPotter,półka3);
        System.out.println(półka2);
        System.out.println(półka3);
    }

    public void przełóżKsiążkęNull(){
        System.out.println("IV test: ");
        biblioteka.przełóżKsiążkę(półka2, harryPotter, półka1);
        System.out.println(półka2);
        System.out.println(półka1);
    }

    public void zdejmijKsiążki(){
        System.out.println("V test: pre " + półka4);
        biblioteka.zdejmijKsiążki(półka4,3,5);
        System.out.println("V test: post " + półka4);
    }

    public void opróżnijPółke(){
        System.out.println("VI test: pre" + półka4);
        biblioteka.opróżnijPółkę(półka4);
        System.out.println("VI test: post: " + półka4);
    }

    public void liczbaPozycjiNaPółce(){
        System.out.println("VII test: " + biblioteka.liczbaPozycjiNaPółce(półka3));
    }

    public void numerPozycjiNaPółce(){
        System.out.println("VIII test: ");
        int wynik = biblioteka.numerPozycjiNaPółce(panTadeusz,półka3);
        if(wynik != BRAK_KSIĄŻKI_NA_PÓŁCE){
            System.out.println(wynik);
        } else {
            System.out.println("Na wybranej półce nie ma takiej pozycji");
        }
    }

    public static void main(String[] args) {
        BibliotekaTest bibliotekaTest = new BibliotekaTest();
        bibliotekaTest.dodanieNaPółkę();
        bibliotekaTest.wypiszZawartość();
        bibliotekaTest.przełóżKsiążke();
        bibliotekaTest.przełóżKsiążkęNull();
        bibliotekaTest.zdejmijKsiążki();
        bibliotekaTest.opróżnijPółke();
        bibliotekaTest.liczbaPozycjiNaPółce();
        bibliotekaTest.numerPozycjiNaPółce();
    }
}
