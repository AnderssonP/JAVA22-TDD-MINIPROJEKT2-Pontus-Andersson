package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.Prime;

public class PrimeTest {
	
	@Test
	void calculateTest() {
		
		Prime prime = new Prime(1, 1000);

        List<Integer> primes = prime.getPrimes();

        assertNotNull(primes);

        assertFalse(primes.isEmpty());

        for (Integer primeNumber : primes) {
            assertNotNull(primeNumber);
        }
		
	}
	
	@Test
	void isPrimeTest() {
		Prime prime = new Prime(2, 10);
        
        assertTrue(prime.numIsPrime(2, 0));
        assertTrue(prime.numIsPrime(3, 0));
        assertTrue(prime.numIsPrime(5, 0));
        assertTrue(prime.numIsPrime(7, 0));

        assertFalse(prime.numIsPrime(4, 1));
        assertFalse(prime.numIsPrime(6, 1));
        assertFalse(prime.numIsPrime(8, 1));
        assertFalse(prime.numIsPrime(9, 1));
        assertFalse(prime.numIsPrime(10, 1));
	}

}
