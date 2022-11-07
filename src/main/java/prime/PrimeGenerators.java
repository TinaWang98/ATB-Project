//generate list containing prime numbers smaller or equal to n
//using brute force method or sieve of Eratosthenes
package prime;

import java.util.*;

public class PrimeGenerators {
    //sieve of Eratosthenes
    public List<Integer> sieveOfEratosthenesFindPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        //create a boolean array A of size n+1 with values set to True
        boolean[] A = new boolean[n+1];
        Arrays.fill(A,true);
        for(int i = 2; i * i <= n; i++) {
            if(A[i]){
                //mark all non-prime numbers
                for(int j = i * i; j <= n; j += i){
                    A[j] = false;
                }
            }
        }
        //add all prime numbers to list
        //A[i]==false -> i is not a prime. A[i]==true -> i is prime
        for(int i = 2; i <= n; i++){
            if(A[i]){
                list.add(i);
            }
        }
        return list;
    }

    //Brute force
    public List<Integer> bruteForceFindPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }

    //isPrime function
    boolean isPrime(int number) {
        if(number <= 1) return false;
        for(int i = 2;i <= number/2;i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }
}
