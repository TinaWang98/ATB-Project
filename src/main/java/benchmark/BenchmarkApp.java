package benchmark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import prime.PrimeGenerators;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * PrimeGeneratorsApp is a simple console application which generates a list of prime numbers
 * less than or equal to n.
 *
 * @author tina
 */

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
//@State(Scope.Thread)
public class BenchmarkApp {
    /**
     * Runs the application
     */
    @Param({"1"})
    public static int n;
    Executor threadPool = Executors.newFixedThreadPool(2);
    public static void run(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to PrimeGeneratorsApp!");
        System.out.println("Please input n: ");

        while(!scan.hasNextInt()) {
            System.out.println("Please enter an integer:");
            scan = new Scanner(System.in);
        }
        n = scan.nextInt();
//        PrimeGenerators app = new PrimeGenerators();
//        app.bruteForceFindPrimes(n);
//        int totalPrime = app.sieveOfEratosthenesFindPrimes(n).size();
//        System.out.println("We have "+totalPrime+" prime numbers within "+n+".");
    }

    @Benchmark
      public List<Integer> testSieveOfEratosthenesFindPrimes(){
        PrimeGenerators app = new PrimeGenerators();
        //System.out.println("findprimes: "+n);
        return app.sieveOfEratosthenesFindPrimes(n);
    }

    @Benchmark
    public List<Integer> testBruteForceFindPrimes(){
        PrimeGenerators app = new PrimeGenerators();
        return app.bruteForceFindPrimes(n);
    }

    public static void main(String[] args) throws RunnerException {
        BenchmarkApp.run();
        //System.out.println("main"+n);
        Options opt = new OptionsBuilder()
                .include(BenchmarkApp.class.getSimpleName())
                .param("n", String.valueOf(n)) // Use this to selectively constrain/override parameters
                .build();

        new Runner(opt).run();
    }


}
