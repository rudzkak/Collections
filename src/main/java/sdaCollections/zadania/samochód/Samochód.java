package sdaCollections.zadania.samochód;

import java.util.Objects;

public class Samochód {

    private String marka;
    private String model;
    private int rokProdukcji;
    private int cena;

    public Samochód(String marka, String model, int rokProdukcji, int cena) {
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.cena = cena;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Samochód{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", rokProdukcji=" + rokProdukcji +
                ", cena=" + cena +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Samochód samochód = (Samochód) o;
        return rokProdukcji == samochód.rokProdukcji &&
                Objects.equals(marka, samochód.marka) &&
                Objects.equals(model, samochód.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marka, model, rokProdukcji);
    }
}
