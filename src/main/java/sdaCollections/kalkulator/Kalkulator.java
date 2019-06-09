package sdaCollections.kalkulator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Kalkulator {


    public int oblicz(String input) {
        Deque<String> stos = new ArrayDeque<>();
        String[] składowe = input.split(" ");

        for(String składowa : składowe){
            stos.add(składowa);
        }

        while (stos.size()>1){
            int lewaStrona = Integer.parseInt(stos.pop());
            String znak = stos.pop();
            int prawaStrona = Integer.parseInt(stos.pop());

            int wynik = 0;

            switch (znak){
                case "+":
                    wynik = lewaStrona + prawaStrona;
                    break;
                case "-":
                    wynik = lewaStrona - prawaStrona;
                    break;
            }
            stos.push(String.valueOf(wynik));
        }
        return Integer.parseInt(stos.pop());
    }
}
