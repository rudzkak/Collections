package sdaCollections.zadania.sklepZoologiczny;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class SklepZoologiczny {

    private List<Zwierzę> listaZwierząt = new ArrayList<>();
    private Set<Zwierzę> setZwierząt = new HashSet<>();

    public void dodajZwierzę(Zwierzę zwierzę) {
        listaZwierząt.add(zwierzę);
        setZwierząt.add(zwierzę);
    }

    public void kupionoZwierzę(Zwierzę zwierzę) {
        if (listaZwierząt.contains(zwierzę) && setZwierząt.contains(zwierzę)) {
            int licznik = 0;
            for (Zwierzę zwierz : listaZwierząt) {
                if (zwierz.equals(zwierzę)) {
                    licznik++;
                }
            }
            if (licznik == 1) {
                setZwierząt.remove(zwierzę);
            }
            listaZwierząt.remove(zwierzę);
        }
    }

    public List<Zwierzę> znajdźRodzaj(String rodzaj) {
        List<Zwierzę> lista = new ArrayList<>();
        for (Zwierzę zwierzę : listaZwierząt) {
            if (zwierzę.getRodzaj().equals(rodzaj)) {
                lista.add(zwierzę);
            }
        }
        return lista;
    }


    public List<Zwierzę> znajdźRodzajJava8(String rodzaj) {
        return listaZwierząt.stream()
                .filter(zwierzę -> zwierzę.getRodzaj().equals(rodzaj))
                .collect(toList());
    }

    public List<Zwierzę> znajdźGatunek(String gatunek) {
        List<Zwierzę> lista = new ArrayList<>();
        for (Zwierzę zwierzę : listaZwierząt) {
            if (zwierzę.getGatunek().equals(gatunek)) {
                lista.add(zwierzę);
            }
        }
        return lista;
    }

    public List<Zwierzę> znajdźGatunekJava8(String gatunek){
        return listaZwierząt.stream()
                .filter(zwierzę -> zwierzę.getGatunek().equals(gatunek))
                .collect(toList());
    }

    public void wypiszZKataloguZwierzątDostępneZwierzętaOprócz(String gatunek){
        for(Zwierzę zwierzę: setZwierząt){
            if(!zwierzę.getGatunek().equals(gatunek)){
                System.out.println(zwierzę);
            }
        }
    }

    public void wypiszZKataloguZwierzątDostępneZwierzętaOpróczJava8(String gatunek){
        setZwierząt.stream()
               .filter(zwierzę -> !zwierzę.getGatunek().equals(gatunek))
                .forEach(System.out::println);
    }

    public int znajdźLiczbęDostępnychZwierząt(String gatunek){
        int licznik = 0;
        for(Zwierzę zwierzę : listaZwierząt){
            if(zwierzę.getGatunek().equals(gatunek)){
                licznik++;
            }
        }
        return licznik;
    }

    public long znajdźLiczbęDostępnychZwierzątJava8(String gatunek){
        return listaZwierząt.stream()
                .filter(zwierzę -> zwierzę.getGatunek().equals(gatunek))
                .count();
    }

    public int obliczWartośćZamówienia(Zamówienie zamówienie){
        return zamówienie.getIlość() * zamówienie.getZwierzę().getCena();
    }


    public static void main(String[] args) {
        Zwierzę zwierzę1 = new Zwierzę("ssak", "pies", 550);
        Zwierzę zwierzę2 = new Zwierzę("ssak", "pies", 550);
        Zwierzę zwierzę3 = new Zwierzę("ssak", "pies", 550);
        Zwierzę zwierzę4 = new Zwierzę("płaz", "żaba", 35);
        Zwierzę zwierzę5 = new Zwierzę("ryba", "złota rybka", 50);
        Zwierzę zwierzę6 = new Zwierzę("ryba", "złota rybka", 50);

        SklepZoologiczny sklepZoologiczny = new SklepZoologiczny();

        sklepZoologiczny.dodajZwierzę(zwierzę1);
        sklepZoologiczny.dodajZwierzę(zwierzę2);
        sklepZoologiczny.dodajZwierzę(zwierzę3);
        sklepZoologiczny.dodajZwierzę(zwierzę4);
        sklepZoologiczny.dodajZwierzę(zwierzę5);
        sklepZoologiczny.dodajZwierzę(zwierzę6);

        System.out.println("I test: lista " + sklepZoologiczny.listaZwierząt);
        System.out.println("I test: set " + sklepZoologiczny.setZwierząt);

        sklepZoologiczny.kupionoZwierzę(zwierzę1);
        System.out.println();
        System.out.println("II test: lista " + sklepZoologiczny.listaZwierząt);
        System.out.println("II test: set " + sklepZoologiczny.setZwierząt);

        System.out.println();
        System.out.println("III test: zwierzęta rodzaju " + sklepZoologiczny.znajdźRodzaj("ssak"));
        System.out.println();
        System.out.println("IV test: zwierzęta rodzaju " + sklepZoologiczny.znajdźRodzajJava8("ssak"));

        System.out.println();
        System.out.println("V test: zwierzęta gatunku " + sklepZoologiczny.znajdźGatunek("żaba"));
        System.out.println();
        System.out.println("VI test: zwierzęta gatunku " + sklepZoologiczny.znajdźGatunekJava8("złota rybka"));
        System.out.println();
        System.out.println("VII test :");
        sklepZoologiczny.wypiszZKataloguZwierzątDostępneZwierzętaOprócz("złota rybka");
        System.out.println();
        System.out.println("VIII test :");
        sklepZoologiczny.wypiszZKataloguZwierzątDostępneZwierzętaOpróczJava8("złota rybka");
        System.out.println();
        System.out.println("IX test: " + sklepZoologiczny.znajdźLiczbęDostępnychZwierząt("złota rybka"));
        System.out.println();
        System.out.println("X test: " + sklepZoologiczny.znajdźLiczbęDostępnychZwierzątJava8("złota rybka"));


        Zamówienie zamówienie = new Zamówienie(zwierzę2, 2);
        System.out.println();
        System.out.println("XI test: " + sklepZoologiczny.obliczWartośćZamówienia(zamówienie));
    }
}
