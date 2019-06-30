package sdaCollections.zadania.sklep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sklep {

    private String miasto;
    private Queue<Produkt> kolejkaProduktów = new PriorityQueue<>(Produkt.BY_CENA);
    private Map<GatunekProduktu, List<Produkt>> mapaSklepu = new HashMap<>();
    private List<Produkt> listaProduktówDanegoGatunku = new ArrayList<>();

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public Map<GatunekProduktu, List<Produkt>> getMapaSklepu() {
        return mapaSklepu;
    }

    public void setMapaSklepu(Map<GatunekProduktu, List<Produkt>> mapaSklepu) {
        this.mapaSklepu = mapaSklepu;
    }

    public Sklep(){}

    public Sklep(String miasto, Map<GatunekProduktu, List<Produkt>> mapaSklepu) {
        this.miasto = miasto;
        this.mapaSklepu = mapaSklepu;
    }

    public void dodajProduktDoSklepu(Produkt produkt){
        kolejkaProduktów.offer(produkt);
        if(mapaSklepu.containsKey(produkt.getGatunekProduktu())){
            mapaSklepu.get(produkt.getGatunekProduktu()).add(produkt);
        } else {
            List<Produkt> lista = new ArrayList<>();
            lista.add(produkt);
            mapaSklepu.put(produkt.getGatunekProduktu(), lista);
        }
    }
    public void usuńProduktZeSklepu(Produkt produkt){
        kolejkaProduktów.remove(produkt);
        if(mapaSklepu.containsKey(produkt.getGatunekProduktu())){
            mapaSklepu.get(produkt.getGatunekProduktu()).remove(produkt);
        }
    }

    public List<Produkt> zwrocProduktyDanegoProducenta(Producent producent){
        List<Produkt> lista = new ArrayList<>();
        for(Map.Entry<GatunekProduktu, List<Produkt>> wpis : mapaSklepu.entrySet()){
            for(Produkt produkt : wpis.getValue()){
                if(produkt.getProducent().equals(producent)){
                    lista.add(produkt);
                }
            }
        }
        return lista;
    }

    public List<Produkt> zwrocProduktyDanegoGatunku(GatunekProduktu gatunekProduktu){
        List<Produkt> lista = new ArrayList<>();
        if(mapaSklepu.containsKey(gatunekProduktu)){
            return mapaSklepu.get(gatunekProduktu);
        }
        return lista;
    }

    public List<Produkt> zwrocDostepneProduktyDanegoGatunkuDoPodanejCeny(GatunekProduktu gatunekProduktu,double cena){
        List<Produkt> lista = new ArrayList<>();
        if(mapaSklepu.containsKey(gatunekProduktu)){
            for(Produkt produkt : mapaSklepu.get(gatunekProduktu)){
                if(produkt.getCena()<= cena){
                    lista.add(produkt);
                }
            }
        }
        return lista;
    }

    public void wypisywanieZKolejki(){
        while (kolejkaProduktów.peek() != null){
            System.out.println(kolejkaProduktów.poll());
        }
    }

    public static void main(String[] args) {
        Produkt umywalka = new Produkt(GatunekProduktu.CERAMIKA, "umywalka",Producent.MYDŁOIPOWIDŁO, 320.55);
        Produkt zasłony = new Produkt(GatunekProduktu.TEKSTYLIA, "zasłony", Producent.MYDŁOIPOWIDŁO, 320.12);
        Produkt gwozdz = new Produkt(GatunekProduktu.METALOWE, "gwozdz", Producent.GWOŹDZIARZE, 1.2);
        Produkt zasłony2 = new Produkt(GatunekProduktu.TEKSTYLIA, "zasłony", Producent.MYDŁOIPOWIDŁO, 210.20);

        Sklep sklep = new Sklep();
        sklep.dodajProduktDoSklepu(umywalka);
        sklep.dodajProduktDoSklepu(zasłony);
        sklep.dodajProduktDoSklepu(gwozdz);
        sklep.dodajProduktDoSklepu(zasłony2);

        System.out.println("Kolejka: "  );
        sklep.kolejkaProduktów.forEach(System.out::println);
        System.out.println("Mapa: ");
        sklep.mapaSklepu.forEach((gatunekProduktu, produkty) ->
                System.out.println(gatunekProduktu + "->" + produkty));

//        sklep.usuńProduktZeSklepu(umywalka);
//        System.out.println("-----");
//        System.out.println("Kolejka: "  );
//        sklep.kolejkaProduktów.forEach(System.out::println);
//        System.out.println("Mapa: ");
//        sklep.mapaSklepu.forEach((gatunekProduktu, produkty) ->
//                System.out.println(gatunekProduktu + "->" + produkty));

        System.out.println("----");
        System.out.println(sklep.zwrocProduktyDanegoGatunku(GatunekProduktu.TEKSTYLIA));

        System.out.println("----");
        System.out.println(sklep.zwrocProduktyDanegoProducenta(Producent.MYDŁOIPOWIDŁO));

        System.out.println("----");
        System.out.println(sklep.zwrocDostepneProduktyDanegoGatunkuDoPodanejCeny(GatunekProduktu.TEKSTYLIA, 250));

        System.out.println("----");
        sklep.wypisywanieZKolejki();
    }
}
