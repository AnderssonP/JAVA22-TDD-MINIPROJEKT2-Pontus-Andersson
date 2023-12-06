package main;

import java.util.ArrayList;
import java.util.List;

public class Prime {

    private List<Integer> primes;
    private int count = 0;
    private int sumOfPrimes = 0;

    public Prime(int firstNumber, int lastNumber) {
        primes = new ArrayList<>();
        calculatePrimes(firstNumber, lastNumber);
    }

    public boolean numIsPrime(int current) {
        if (current < 2) {
            return false;
        }
        for (int prime : primes) {
            if (prime > Math.sqrt(current)) {
                break;
            }
            if (current % prime == 0) {
                return false;
            }
        }
        return true;
    }

    private void calculatePrimes(int current, int stop) {
        if (current > stop) {
            printCount();
            printSum();
        } else if (numIsPrime(current)) {
            primes.add(current);
            ++count;
            sumOfPrimes += current;
            calculatePrimes(++current, stop);
        } else {
            calculatePrimes(++current, stop);
        }
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    public void printCount() {
        System.out.println("Hej, det finns " + count + " primtal mellan 0 och 1000!");
    }

    public void printSum() {
        System.out.println("Och den totala summan av dessa primtal är " + sumOfPrimes + ".");
    }

    public static void main(String[] args) {
        int firstNumber = 0;
        int lastNumber = 1000;

        if (isValidInterval(firstNumber, lastNumber)) {
            Prime prime = new Prime(firstNumber, lastNumber);
        } else {
            System.out.println("Hoppsan, fel intervall angivet!");
        }
    }

    public static boolean isValidInterval(int firstNumber, int lastNumber) {
        return firstNumber >= 0 && lastNumber <= 1000 && firstNumber <= lastNumber;
    }
}
