package sdaCollections.wysyłka;

import sdaCollections.Produkt;

public class PocztaTest {

    Produkt drzwi = new Produkt("drzwi dębowe", 40);
    Produkt okno = new Produkt("okno dębowe", 30);
    Produkt panel = new Produkt("panel dębowy", 5);
    Produkt deska = new Produkt("deska sosnowa", 5);


    private Poczta poczta = new Poczta();

    public void dodanieProduktu(){
        poczta.dodaj(drzwi);
        poczta.dodaj(okno);

        System.out.println("I test: " + "\n" + poczta);
    }

    public void zamianaProduktu(){
        poczta.zamień(okno, panel);

        System.out.println("II test: " + "\n" + poczta);
    }

    public void zamianaNieistniejącegoProduktu(){
        poczta.zamień(okno, deska);

        System.out.println("III test: " + "\n" + poczta);
    }

    public void podziałNaVany(){
        Poczta pocztaVany = new Poczta();
        pocztaVany.dodaj(okno);
        pocztaVany.dodaj(deska);
        pocztaVany.dodaj(drzwi);
        pocztaVany.dodaj(panel);

        pocztaVany.przygotujPrzesyłke();

        System.out.println("IV test: " + "\n" + "zawartość małego vana: " + pocztaVany.getMalyVanProdukty());
        System.out.println("zawartość dużego vana: " + pocztaVany.getDuzyVanProdukty());
    }

    public static void main(String[] args) {
        PocztaTest pocztaTest = new PocztaTest();
        pocztaTest.dodanieProduktu();
        pocztaTest.zamianaProduktu();
        pocztaTest.zamianaNieistniejącegoProduktu();
        pocztaTest.podziałNaVany();
    }
}
