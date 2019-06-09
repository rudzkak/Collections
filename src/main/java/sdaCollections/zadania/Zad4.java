package sdaCollections.zadania;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Zad4 {

    public static void main(String[] args) {
        Queue<Double> kolejka = new PriorityQueue<>(Double::compareTo);

        Random random = new Random();

        do{
            kolejka.offer(random.nextDouble());
        } while(kolejka.size()<20);

        while (kolejka.peek() != null){
            System.out.println(kolejka.remove());
        }
    }
}
