package prime;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorsTest {
    PrimeGenerators primeGenerators;

    @BeforeEach
    void setPrimeGenerators(){
        primeGenerators = new PrimeGenerators();
    }

    @Test
    @DisplayName("IsPrime should work")
    void testIsPrime(){
        assertEquals(false,primeGenerators.isPrime(-1));
        assertEquals(false,primeGenerators.isPrime(0));
        assertEquals(false,primeGenerators.isPrime(1));
        assertEquals(true,primeGenerators.isPrime(2));
        assertEquals(true,primeGenerators.isPrime(7));
        assertEquals(true,primeGenerators.isPrime(17));
        assertEquals(false,primeGenerators.isPrime(100));
        assertEquals(false,primeGenerators.isPrime(1020));
        assertEquals(false,primeGenerators.isPrime(10000002));
    }

    @Test
    @DisplayName("Sieve Of Eratosthenes method should work")
    void testSieveOfEratosthenesFindPrimes(){

        //Expected null list for negative numbers, 0 and 1
        List<Integer> nullList_Negatives = primeGenerators.sieveOfEratosthenesFindPrimes(-1);
        assertEquals(nullList_Negatives.size(),0);

        List<Integer> nullList_Zero = primeGenerators.sieveOfEratosthenesFindPrimes(0);
        assertEquals(nullList_Zero.size(),0);

        List<Integer> nullList_One = primeGenerators.sieveOfEratosthenesFindPrimes(1);
        assertEquals(nullList_One.size(),0);

        //Expected prime numbers list for 2
        List<Integer> testList_2  = primeGenerators.sieveOfEratosthenesFindPrimes(2);
        assertEquals(testList_2.size(),1);
        assertEquals(testList_2.get(0),2);

        //Expected prime numbers list for 3
        List<Integer> testList_3  = primeGenerators.sieveOfEratosthenesFindPrimes(3);
        assertEquals(testList_3.size(),2);
        assertEquals(testList_3.get(0),2);
        assertEquals(testList_3.get(1),3);

        //Expected prime numbers list for 100
        List<Integer> testList_100 = primeGenerators.sieveOfEratosthenesFindPrimes(100);
        assertEquals(testList_100.size(),25);
        assertEquals(testList_100.get(24),97);
        for(int num:testList_100){
            assertEquals(true,primeGenerators.isPrime(num));
        }

        //Expected prime numbers list for 5000000
        List<Integer> testList_5000000 = primeGenerators.sieveOfEratosthenesFindPrimes(5000000);
        assertEquals(testList_5000000.size(),348513);
        assertEquals(testList_5000000.get(testList_5000000.size()-1),4999999);
    }

    @Test
    @DisplayName("Brute force method should work")
    void testBruteForceFindPrimes(){
        //Expected null list for negative numbers, 0 and 1
        List<Integer> nullList_Negatives = primeGenerators.bruteForceFindPrimes(-1);
        assertEquals(nullList_Negatives.size(),0);

        List<Integer> nullList_Zero = primeGenerators.bruteForceFindPrimes(0);
        assertEquals(nullList_Zero.size(),0);

        List<Integer> nullList_One = primeGenerators.bruteForceFindPrimes(1);
        assertEquals(nullList_One.size(),0);

        //Expected prime numbers list for 2
        List<Integer> testList_2  = primeGenerators.bruteForceFindPrimes(2);
        assertEquals(testList_2.size(),1);
        assertEquals(testList_2.get(0),2);

        //Expected prime numbers list for 3
        List<Integer> testList_3  = primeGenerators.bruteForceFindPrimes(3);
        assertEquals(testList_3.size(),2);
        assertEquals(testList_3.get(0),2);
        assertEquals(testList_3.get(1),3);

        //Expected prime numbers list for 100
        List<Integer> testList_100 = primeGenerators.bruteForceFindPrimes(100);
        assertEquals(testList_100.size(),25);
        assertEquals(testList_100.get(24),97);
        for(int num:testList_100){
            assertEquals(true,primeGenerators.isPrime(num));
        }

        //Expected prime numbers list for 5000000
//        List<Integer> testList_5000000 = primeGenerators.bruteForceFindPrimes(5000000);
//        assertEquals(testList_5000000.size(),348513);
//        assertEquals(testList_5000000.get(testList_5000000.size()-1),4999999);
    }
}
