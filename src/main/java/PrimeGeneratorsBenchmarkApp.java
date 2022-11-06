import benchmark.JMHBenchmarkApp;
import benchmark.PrimeGeneratorsBenchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Starter class for prime generater application
 * @author tina
 */

public class PrimeGeneratorsBenchmarkApp {
    /**
     * Application entry point
     *
     * @param args application command line arguments
     */
    public static void main(String[] args) {
        PrimeGeneratorsBenchmark primeGeneratorsBenchmark = new PrimeGeneratorsBenchmark();
        primeGeneratorsBenchmark.run();

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        threadPool.execute(new Runnable() {
            public void run() {
                primeGeneratorsBenchmark.bruteForceBenchmark();
                countDownLatch.countDown();
            }
        });
        threadPool.execute(new Runnable() {
            public void run() {
                primeGeneratorsBenchmark.sieveOfEratosthenesBenchmark();
                countDownLatch.countDown();
            }
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
            primeGeneratorsBenchmark.printReport();
        }

    }
}
