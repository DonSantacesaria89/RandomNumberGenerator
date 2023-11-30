package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class RandomNumberGenerator {

    public static int[] generateUniqueRandomNumbersInRange(String lowerLimit, String upperLimit, String numCount)
            throws IllegalArgumentException {

        try {
            // Conversione degli operandi in interi
            int lower = Integer.parseInt(lowerLimit);
            int upper = Integer.parseInt(upperLimit);
            int count = Integer.parseInt(numCount);

            if((upper-lower+1)<count){
                throw new IllegalArgumentException("\n->Errore: Il numero degli elementi da generare deve essere almeno uguale alla differenza+1 tra il limite superiore ed il limite inferiore.");
            }

            // Verifica se l'intervallo è valido
            if (lower >= upper) {
                throw new IllegalArgumentException("\n->Errore: Limite inferiore deve essere inferiore al limite superiore.");
            }

            // Verifica se il numero di numeri è positivo
            if (count <= 0) {
                throw new IllegalArgumentException("\n->Errore: Il numero di elementi deve essere positivo.");
            }

            Set<Integer> uniqueNumbers = new HashSet<>();
            Random random = new Random();

            // Genera numeri unici nell'intervallo
            while (uniqueNumbers.size() < count) {
                int randomNumber = random.nextInt(upper - lower + 1) + lower;
                uniqueNumbers.add(randomNumber);
            }

            // Converti il set in un array ordinato
            int[] result = uniqueNumbers.stream().sorted().mapToInt(Integer::intValue).toArray();

            return result;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("\n->Errore: Inserito un valore non valido. Assicurati di inserire valori validi.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input del limite inferiore
        System.out.print("Inserisci il limite inferiore dell'intervallo (Inserisci 'q' per terminare): ");
        String lowerLimit = scanner.next();

        while (!lowerLimit.equals("q")) {
            try {

                // Input del limite superiore
                System.out.print("Inserisci il limite superiore dell'intervallo: ");
                String upperLimit = scanner.next();

                // Input del numero di numeri da generare
                System.out.print("Inserisci il numero degli elementi da generare nell'intervallo indicato: ");
                String numCount = scanner.next();

                // Genera l'intervallo e stampa i risultati
                int[] generatedNumbers = generateUniqueRandomNumbersInRange(lowerLimit, upperLimit, numCount);
                System.out.println("Numeri generati nell'intervallo:");
                for (int num : generatedNumbers) {
                    System.out.print(num + " ");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            // Input del limite inferiore
            System.out.print("\n\nInserisci il limite inferiore dell'intervallo (Inserisci 'q' per terminare): ");
            lowerLimit = scanner.next();
        }
        System.out.println("\n+++CHIUSURA PROGRAMMA IN CORSO+++");
        scanner.close();

    }
}
