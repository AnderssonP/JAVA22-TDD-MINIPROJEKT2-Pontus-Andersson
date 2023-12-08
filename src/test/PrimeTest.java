package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Prime;

class PrimeTest {

    @Test
    @DisplayName("Testa primtalsberäkning och listan")
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
    @DisplayName("Testa primtalen")
    void isPrimeTest() {
        Prime prime = new Prime(1, 1000);

        assertTrue(prime.numIsPrime(2));
        assertTrue(prime.numIsPrime(3));
        assertTrue(prime.numIsPrime(53));
        assertTrue(prime.numIsPrime(571));

        assertFalse(prime.numIsPrime(1));
        assertFalse(prime.numIsPrime(12));
        assertFalse(prime.numIsPrime(50));
        assertFalse(prime.numIsPrime(315));
        assertFalse(prime.numIsPrime(702));
    }

    @Test
    @DisplayName("Testa meddelandet för ogiltigt intervall")
    void testInvalidIntervalMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        int firstNumber = 1001;
        int lastNumber = 1500;

        assertFalse(Prime.isValidInterval(firstNumber, lastNumber));

        if (!Prime.isValidInterval(firstNumber, lastNumber)) {
            Prime prime = new Prime(firstNumber, lastNumber);
            assertEquals("Hoppsan, fel intervall angivet!\n", outContent.toString());
        }

        System.setOut(System.out);
    }

    @Test
    @DisplayName("Testa giltiga och ogiltiga intervall")
    void testValidInterval() {
        assertTrue(Prime.isValidInterval(0, 1000));
        assertTrue(Prime.isValidInterval(500, 700));
        assertFalse(Prime.isValidInterval(1001, 1500));
        assertFalse(Prime.isValidInterval(1000, 0));
        assertFalse(Prime.isValidInterval(-10, 100));
    }

    @Test
    @DisplayName("Testa null i primtalsberäkning")
    void testNullValues() {
        Prime prime = new Prime(0, 0);

        List<Integer> primes = prime.getPrimes();

        assertNotNull(primes);
        assertTrue(primes.isEmpty());
    }

    @Test
    @DisplayName("Test för ogiltig primtalsberäkning")
    void testInvalidCalculation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Prime(1000, 0); 
        });
    }
}
