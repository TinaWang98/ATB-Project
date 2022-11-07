package benchmark;
/**
 * PrimeGeneratorsBenchmark is a class that defines the CLI,
 * develops the benchmark method of Sieve of Eratosthenes,
 * develops the benchmark method of brute force method and develops the printReport method.
 *
 * @author tina
 */

import org.openjdk.jmh.annotations.Measurement;
import prime.PrimeGenerators;

import java.util.Optional;
import java.util.Scanner;

public class PrimeGeneratorsBenchmark {
    private int n;
    private long timeSieveOfEratosthenes;
    private long timeBruteForce;
    private long usedMemSieveOfEratosthenes;
    private long usedMemBruteForce;
    private TimeMeasurement timeMeasurement;
    private MemoryMeasurement memoryMeasurement;
    private PrimeGenerators primeGenerators;

    public PrimeGeneratorsBenchmark() {
        timeMeasurement = new TimeMeasurement();
        memoryMeasurement = new MemoryMeasurement();
        primeGenerators = new PrimeGenerators();
        n = 0;
        timeSieveOfEratosthenes = 0;
        timeBruteForce = 0;
        usedMemBruteForce = 0;
        usedMemSieveOfEratosthenes = 0;
    }
    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("# Welcome to PrimeGeneratorsBenchmarkApp!");
        System.out.println("# Please input n: ");

        while(!scan.hasNextInt()) {
            System.out.println("# Please enter an integer:");
            scan = new Scanner(System.in);
        }
        n = scan.nextInt();
        System.out.println("# Please wait...");
    }

    public void sieveOfEratosthenesBenchmark() {
        long eachTime = 0;
        long eachMemory = 0;
        for(int i = 1; i <= 10; i++){
            eachTime = timeMeasurement.getTime(new TimeMeasurement.TimeMeasurementExecutor() {
                @Override
                public void execute() {
                    primeGenerators.sieveOfEratosthenesFindPrimes(n);
                }
            });

            eachMemory = memoryMeasurement.getMemory(new MemoryMeasurement.MemoryMeasurementExecutor() {
                @Override
                public void execute() {
                    primeGenerators.sieveOfEratosthenesFindPrimes(n);
                }
            });

            //First five iterations for warming up
            if(i>5) {
                timeSieveOfEratosthenes += eachTime;
                usedMemSieveOfEratosthenes += eachMemory;
                System.out.println("# Sieve Of Eratosthenes Iteration time " + (i-5) + ": " + eachTime + " ns");
                System.out.println("# Sieve Of Eratosthenes Iteration memory " + (i-5) + ": " + eachMemory/1024 + " KB");
            }
        }
    }

    public void bruteForceBenchmark() {
        long eachTime = 0;
        long eachMemory = 0;
        for(int i = 1; i <= 10; i++) {
            eachTime = timeMeasurement.getTime(new TimeMeasurement.TimeMeasurementExecutor() {
                @Override
                public void execute() {
                    primeGenerators.bruteForceFindPrimes(n);
                }
            });

            eachMemory = memoryMeasurement.getMemory(new MemoryMeasurement.MemoryMeasurementExecutor() {
                @Override
                public void execute() {
                    primeGenerators.bruteForceFindPrimes(n);
                }
            });

            //First five iterations for warming up
            if(i>5) {
                timeBruteForce += eachTime;
                usedMemBruteForce += eachMemory;
                System.out.println("# Brute Force Iteration time " + (i-5) + ": " + eachTime + " ns");
                System.out.println("# Brute Force Iteration memory " + (i-5) + ": " + eachMemory/1024 + " KB");
            }
        }
    }

    public void printReport() {
        System.out.println();
        System.out.println("--------------Final Result-----------------");
        System.out.println("# Used memory of SieveOfEratosthenes: " + (double)usedMemSieveOfEratosthenes/5/1024 + "KB");
        System.out.println("# Used memory of BruteForce: " + (double)usedMemBruteForce/5/1024 + "KB");
        System.out.println("# Average runtime for SieveOfEratosthenes: " + (double)timeSieveOfEratosthenes/5 + "ns");
        System.out.println("# Average runtime for BruteForce: " + (double)timeBruteForce/5 + "ns");
        String str = timeSieveOfEratosthenes > timeBruteForce ? "# Brute Force is faster" : "# Sieve Of Eratosthenes is faster";
        System.out.println(str);
    }

}
