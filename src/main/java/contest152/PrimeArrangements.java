package contest152;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeArrangements {

    @Test
    public void test() {
        Assertions.assertEquals(12, numPrimeArrangements(5));
    }

    public long numPrimeArrangements(int num) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (isPrime(i))
                primes.add(i);
        }
        int primeCount = primes.size();

        return (int)(factorial(primeCount).multiply(factorial(num-primeCount)).mod(BigInteger.valueOf((long)Math.pow(10,9)).add(BigInteger.valueOf(7)))).intValue();
    }

    private BigInteger factorial(int i) {
        BigInteger fact = BigInteger.ONE;
        for(int j =2; j<=i;j++)fact= fact.multiply(BigInteger.valueOf(j));
        return fact;

    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
