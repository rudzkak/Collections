package sdaCollections.zadania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Zad1 {

    public static void main(String[] args) {
        System.out.println("Podaj ciąg liczb oddzielonych spacją");

        Scanner skaner = new Scanner(System.in);
        List<Integer> ciagLiczb = new ArrayList<>();

        String [] ciag = skaner.nextLine().split("\\s+");

        if(ciag.length == 1 && ciag[0].equals("")){
            System.out.println("Brak elementów w ciągu");
        } else{

            for(int i = 0; i < ciag.length ; i ++){
                ciagLiczb.add(Integer.parseInt(ciag[i]));
            }

            int sumaDodatnich = 0;
            int sumaUjemnych = 0;
            int sumaCałkowita = 0;
            int liczbaDodatnich = 0;
            int liczbaUjemnych = 0;

            for (Integer liczba : ciagLiczb){
                if(liczba > 0){
                    sumaDodatnich += liczba;
                    liczbaDodatnich += 1;
                } else if (liczba < 0){
                    sumaUjemnych += liczba;
                    liczbaUjemnych +=1;
                }
                sumaCałkowita += liczba;
            }
            System.out.println("Suma liczb dodatnich: " + sumaDodatnich );
            System.out.println("Suma liczb ujemnych: " + sumaUjemnych);
            System.out.println("Suma całkowita: " + sumaCałkowita);
            System.out.println("Liczba liczb dodatnich: " + liczbaDodatnich);
            System.out.println("Liczba liczb ujemnych: " + liczbaUjemnych);
        }
    }
}
