package sdaCollections.zadania.sklepZoologiczny;

import java.util.Objects;

public class Zamówienie {

    private Zwierzę zwierzę;
    private int ilość;

    public Zamówienie(Zwierzę zwierzę, int ilość) {
        this.zwierzę = zwierzę;
        this.ilość = ilość;
    }

    public Zwierzę getZwierzę() {
        return zwierzę;
    }

    public void setZwierzę(Zwierzę zwierzę) {
        this.zwierzę = zwierzę;
    }

    public int getIlość() {
        return ilość;
    }

    public void setIlość(int ilość) {
        this.ilość = ilość;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zamówienie that = (Zamówienie) o;
        return ilość == that.ilość &&
                Objects.equals(zwierzę, that.zwierzę);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zwierzę, ilość);
    }

    @Override
    public String toString() {
        return "Zamówienie{" +
                "zwierzę=" + zwierzę +
                ", ilość=" + ilość +
                '}';
    }
}
