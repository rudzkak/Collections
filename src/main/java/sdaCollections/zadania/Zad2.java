package sdaCollections.zadania;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Zad2 {

    public static void main(String[] args) {

        List<Integer> lista = new LinkedList<>();

        Iterator<Integer> iterator = lista.iterator();

        Random random = new Random();

        do{
            lista.add(lista.size()/2, random.nextInt(10));
            System.out.println(lista);
        } while (iterator.hasNext() && lista.size() < 20);
    }
}
