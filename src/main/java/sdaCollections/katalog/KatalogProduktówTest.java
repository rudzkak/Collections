package sdaCollections.katalog;

import sdaCollections.Produkt;

public class KatalogProduktówTest {

    public static Produkt drzwi = new Produkt("drzwi dębowe", 30);
    public static Produkt okno = new Produkt("okno dębowe", 40);
    public static Produkt panel = new Produkt("panel dębowy", 5);
    public static Produkt deksa = new Produkt("deska", 5);

    public static Dostawca jan  = new Dostawca("U Jana");
    public static Dostawca zosia = new Dostawca("Drewno Zosi");

    static {
        jan.getListaProduktów().add(drzwi);
        jan.getListaProduktów().add(drzwi);
        jan.getListaProduktów().add(drzwi);
        jan.getListaProduktów().add(okno);
        jan.getListaProduktów().add(okno);
        jan.getListaProduktów().add(panel);
        jan.getListaProduktów().add(new Produkt("drzwi dębowe", 30));
        jan.getListaProduktów().add(deksa);

        zosia.getListaProduktów().add(panel);
        zosia.getListaProduktów().add(panel);
        zosia.getListaProduktów().add(deksa);
        zosia.getListaProduktów().add(deksa);
        zosia.getListaProduktów().add(deksa);
    }

    public static void main(String[] args) {
        KatalogProduktów katalogProduktów = new KatalogProduktów();

        katalogProduktów.zapewnanianyPrzez(jan);
        System.out.println("lista" + katalogProduktów.listaProduktów);
        System.out.println("set" +katalogProduktów.setProduktów);

        if(drzwi.equals(new Produkt("drzwi dębowe", 30))){
            System.out.println("równe");
        } else {
            System.out.println("inne");
        }

        System.out.println(katalogProduktów.produktyMalyVan());
        System.out.println(katalogProduktów.produktyDuzyVan());
    }
}
