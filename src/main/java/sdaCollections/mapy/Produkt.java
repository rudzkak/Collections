package sdaCollections.mapy;

import java.util.Objects;

public class Produkt {
    private int id;
    private String nazwa;
    private int waga;

    public Produkt(int id, String nazwa, int waga) {
        this.id = id;
        this.nazwa = nazwa;
        this.waga = waga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", waga=" + waga +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produkt produkt = (Produkt) o;
        return id == produkt.id &&
                waga == produkt.waga &&
                Objects.equals(nazwa, produkt.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa, waga);
    }
}
