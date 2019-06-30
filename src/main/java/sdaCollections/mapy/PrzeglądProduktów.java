package sdaCollections.mapy;

public interface PrzeglądProduktów {

    void dodajProdukt(Produkt produktDoDodania);
    Produkt znajdzPoId(int id);
    void wyczyść();
}
