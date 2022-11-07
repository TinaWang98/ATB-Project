package benchmark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import prime.PrimeGenerators;
import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * JMHBenchmark is a simple console application which uses Java Microbenchmark Harness
 * to benchmark the actual performance of Sieve Of Eratosthenes and Brute force method
 *
 * @author tina
 */

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class JMHBenchmarkApp {
    /**
     * Runs the application
     */
    @Param({"1"})
    private int n;
    public void run(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to JMHBenchmarkApp!");
        System.out.println("Please input n: ");

        while(!scan.hasNextInt()) {
            System.out.println("Please enter an integer:");
            scan = new Scanner(System.in);
        }
        n = scan.nextInt();
    }

    @Benchmark
      public List<Integer> testSieveOfEratosthenesFindPrimes(){
        PrimeGenerators app = new PrimeGenerators();
        return app.sieveOfEratosthenesFindPrimes(n);
    }

    @Benchmark
    public List<Integer> testBruteForceFindPrimes(){
        PrimeGenerators app = new PrimeGenerators();
        return app.bruteForceFindPrimes(n);
    }

    public static void main(String[] args) throws RunnerException {
        JMHBenchmarkApp jmhBenchmark = new JMHBenchmarkApp();
        jmhBenchmark.run();
        Options opt = new OptionsBuilder()
                .include(JMHBenchmarkApp.class.getSimpleName())
                .param("n", String.valueOf(jmhBenchmark.n)) // Use this to selectively constrain/override parameters
                .build();

        new Runner(opt).run();
    }
}
