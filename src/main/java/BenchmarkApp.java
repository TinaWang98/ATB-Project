import prime.PrimeGenerators;

import java.util.Scanner;

/**
 * PrimeGeneratorsApp is a simple console application which generates a list of prime numbers
 * less than or equal to n.
 *
 * @author tina
 */
import prime.PrimeGenerators;
import java.util.Scanner;

public class BenchmarkApp {
    /**
     * Runs the application
     */
    void run(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to PrimeGeneratorsApp!");
        System.out.println("Please input n: ");
        int n = 0;
        while(!scan.hasNextInt()) {
            System.out.println("Please enter an integer:");
            scan = new Scanner(System.in);
        }
        n = scan.nextInt();
        PrimeGenerators app = new PrimeGenerators();
        app.bruteForceFindPrimes(n);
        int totalPrime = app.sieveOfEratosthenesFindPrimes(n).size();
        System.out.println("We have "+totalPrime+" prime numbers within "+n+".");
    }
}
