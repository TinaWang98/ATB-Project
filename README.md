# PrimeGeneratorsBenchmarkApp

This repo is for benchmarking the performance (execution time and used memory) of the two different algorithms that find primes less than or equal to a value n.  The programming language is Java.

- [PrimeGeneratorsBenchmarkApp](#primegeneratorsbenchmarkapp)
  - [Get started](#get-started)
  - [Benchmarking Solution](#benchmarking-solution)
  - [Source code review](#source-code-review)
  - [Follow-up Questions](#follow-up-questions)

## Get started

1. Clone this repository

   ```
   git clone https://github.com/TinaWang98/ATB-Project.git
   ```

2. Go to src/main/java

3. Run PrimeGeneratorsBenchmarkApp

4. Input the value n in the command line. (Note: We recommend that n be within 100,000. When n exceeds 100,000, the brute force benchmarking results will take a long time.)

   ```
   # Welcome to PrimeGeneratorsBenchmarkApp!
   # Please input n: 
   ```

5. The measured execution time and memory of each algorithm will be printed.

   ```
   # Please input n: 
   100000
   # Please wait!
   # Sieve Of Eratosthenes Iteration time 1: 586300 ns
   # Sieve Of Eratosthenes Iteration memory 1: 417 KB
   # Sieve Of Eratosthenes Iteration time 2: 2967300 ns
   # Sieve Of Eratosthenes Iteration memory 2: 442 KB
   # Sieve Of Eratosthenes Iteration time 3: 3780100 ns
   # Sieve Of Eratosthenes Iteration memory 3: 442 KB
   # Sieve Of Eratosthenes Iteration time 4: 668300 ns
   # Sieve Of Eratosthenes Iteration memory 4: 442 KB
   # Sieve Of Eratosthenes Iteration time 5: 841400 ns
   # Sieve Of Eratosthenes Iteration memory 5: 442 KB
   # Brute Force Iteration time 1: 1084108800 ns
   # Brute Force Iteration memory 1: 323 KB
   # Brute Force Iteration time 2: 1083972000 ns
   # Brute Force Iteration memory 2: 323 KB
   # Brute Force Iteration time 3: 1058927300 ns
   # Brute Force Iteration memory 3: 323 KB
   # Brute Force Iteration time 4: 1095193500 ns
   # Brute Force Iteration memory 4: 323 KB
   # Brute Force Iteration time 5: 1129847400 ns
   # Brute Force Iteration memory 5: 323 KB
   
   --------------Final Result-----------------
   # Used memory of SieveOfEratosthenes: 437.5875KB
   # Used memory of BruteForce: 323.984375KB
   # Average runtime for SieveOfEratosthenes: 1768680.0ns
   # Average runtime for BruteForce: 1.0904098E9ns
   # Sieve Of Eratosthenes is faster
   
   Process finished with exit code 0
   ```

## Benchmarking Solution 

This program tests the execution time and the used memory of methods. In order to get the correct results, this program iterates each method 10 times to get execution time and used memory, selects the first 5 times as warming up, selects the last 5 times as the final result, and prints the average time and average used memory.

**JMH benchmarking**

If you want to get more thorough results, you could go to src/main/java/benchmark/JMHBenchmarkApp.java and run this file. This file uses java microbenchmark Harness for benchmarking the performance of two methods.

## Source code review

1. src/main/java/benchmark/

   1. MemoryMeasurement.java

      MemoryMeasurement is a class that gets the used memory of a method during the execution time. 

   2. TimeMeasurement.java

      TimeMeasurement is a class that gets the execution time of a method.

   3. PrimeGeneratorsBenchmark.java

      PrimeGeneratorsBenchmark is a class that defines the CLI,  develops the benchmark method of Sieve of Eratosthenes, develops the benchmark method of brute force method and develops the printReport method.

2. src/main/java/prime/PrimeGenerators.java

   PrimeGenerators.java defines a class that develops two different methods to generate a list containing prime numbers smaller or equal to n.

3. src/main/java/PrimeGeneratorsBenchmarkApp.java

   PrimeGeneratorsBenchmarkApp is the main class that uses two threads for running Sieve of Eratosthenes benchmark testing and the Brute force benchmark testing.

4. src/test/java/prime/PrimeGeneratorsTest.java

   Use unit tests to show the correctness of PrimeGeneratos implementation.

   

## Follow-up Questions

**1. Is there any measurable difference between the two algorithms for small values of N?**

Running time:

Brute force method time complexity: O(n^2)

Sieve of Eratosthenes method time complexity: O(n*log(logn))

The brute force runs faster when N is small like 10. When N is within 100, the difference between the running times of the two algorithms is tiny.

Space:

Brute force method space complexity: O(1)

Sieve of Eratosthenes method space complexity: O(n)

When N is small, there is no significant difference in the space occupied by the two methods.

**2. Approximately at what value of N, if any, does the performance gap become significant?**

When N is less than or equal to 100, the gap in execution time is tiny. When N is larger than 100, the gap is slightly significant. When N is over 1000, the gap is very significant. The Sieve of Eratosthenes method is faster.

When N is very large, the Sieve of Eratosthenes method costs more memory than the brute force method.

**3. Do you think it was a good idea to benchmark the two algorithms in parallel? Why or why not?**

I think it's a good idea.

Parallel allows two benchmarks to be run simultaneously, saving running time. The benchmark Brute force method takes a lot of time when N is large. We can get the result of the Sieve of Eratosthenes method first without waiting for brute force to finish benchmarking.

Parallel allows two benchmarks to be carried out independently, and the failure of one benchmark does not affect the other.

**4. In general, does it always make sense to use the algorithms with the best O(n) performance in our code? Describe some scenarios where it could make sense to choose a slower algorithm.**

Sometimes choosing a slower algorithm can perform better.

1. Some algorithms have low average time complexity, but they perform differently depending on the input data. Let's take quick sort and insertion sort as examples. Typically, the time complexity of the quick sort O(nlog(n)) is better than the insertion sort O(n^2). However, when most of the data is ordered or the data size is small, the insertion sort is more efficient.
2. Consider memory constraints. We may choose slower algorithms that take up less memory.
3. Parallel. Some algorithms with high time complexity can be easily computed in parallel. Some algorithms with low complexity cannot be easily computed in parallel. We also choose slower algorithms in this case.
4. Considerations for data security. Sometimes we choose slower algorithms to prevent timing attacks.

