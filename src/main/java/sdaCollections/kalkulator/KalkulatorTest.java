package sdaCollections.kalkulator;

public class KalkulatorTest {
    public static void main(String[] args) {

        Kalkulator kalkulator = new Kalkulator();

        System.out.println("I test: " + kalkulator.oblicz("1") + " powinien = 1");
        System.out.println("II test: " + kalkulator.oblicz("1 + 2") + " powinien = 3");
        System.out.println("III test: " + kalkulator.oblicz("1 - 2") + " powinien = -1");
        System.out.println("IV test: " + kalkulator.oblicz("1 - 3 + 2 + 4") + " powinien = 4");
    }


}
