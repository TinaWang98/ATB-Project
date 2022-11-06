package benchmark;

import prime.PrimeGenerators;
import java.util.Scanner;

public class PrimeGeneratorsBenchmark {
    public int n;
    private long timeSieveOfEratosthenes;
    private long timeBruteForce;
    private TimeMeasurement timeMeasurement;
    private PrimeGenerators primeGenerators;

    public PrimeGeneratorsBenchmark () {
        timeMeasurement = new TimeMeasurement();
        primeGenerators = new PrimeGenerators();
        n = 0;
        timeSieveOfEratosthenes = 0;
        timeBruteForce = 0;
    }
    public void run(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to PrimeGeneratorsApp!");
        System.out.println("Please input n: ");

        while(!scan.hasNextInt()) {
            System.out.println("Please enter an integer:");
            scan = new Scanner(System.in);
        }
        n = scan.nextInt();
    }

    public void sieveOfEratosthenesBenchmark(){
        for(int i = 0; i < 49; i++){
            timeSieveOfEratosthenes += timeMeasurement.getTime(new TimeMeasurement.TimeMeasurementExecutor() {
                @Override
                public void execute() {
                    primeGenerators.sieveOfEratosthenesFindPrimes(n);
                }
            });
        }
    }

    public void bruteForceBenchmark(){
        for(int i = 0; i < 49; i++){
            timeBruteForce += timeMeasurement.getTime(new TimeMeasurement.TimeMeasurementExecutor() {
                @Override
                public void execute() {
                    primeGenerators.bruteForceFindPrimes(n);
                }
            });
        }
    }

    public void printReport(){
        System.out.println("Average runtime for SieveOfEratosthenes: " + (double)timeSieveOfEratosthenes/50 + "ns");
        System.out.println("Average runtime for BruteForce: " + (double)timeBruteForce/50 + "ns");
        String str = timeSieveOfEratosthenes > timeBruteForce ? "Brute Force is faster" : "Sieve Of Eratosthenes is faster";
        System.out.println(str);
    }

}
