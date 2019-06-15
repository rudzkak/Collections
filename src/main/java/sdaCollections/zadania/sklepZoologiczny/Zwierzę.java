package sdaCollections.zadania.sklepZoologiczny;

import java.util.Objects;

public class Zwierzę {

    private String rodzaj;
    private String gatunek;
    private int cena;

    public Zwierzę(String rodzaj, String gatunek, int cena) {
        this.rodzaj = rodzaj;
        this.gatunek = gatunek;
        this.cena = cena;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zwierzę zwierzę = (Zwierzę) o;
        return cena == zwierzę.cena &&
                Objects.equals(rodzaj, zwierzę.rodzaj) &&
                Objects.equals(gatunek, zwierzę.gatunek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rodzaj, gatunek, cena);
    }

    @Override
    public String toString() {
        return "Zwierzę{" +
                "rodzaj='" + rodzaj + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", cena=" + cena +
                '}';
    }
}
