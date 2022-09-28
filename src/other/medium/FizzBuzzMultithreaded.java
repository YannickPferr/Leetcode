package other.medium;

import java.util.function.IntConsumer;

/**
 * Problem: 1195. Fizz Buzz Multithreaded
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsfizz-buzz-multithreaded
 */
class FizzBuzz {
    private int n;
    private int num = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (num <= n) {
            if (num % 3 == 0 && num % 5 != 0) {
                printFizz.run();
                num++;
                notifyAll();
            } else
                wait();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (num <= n) {
            if (num % 3 != 0 && num % 5 == 0) {
                printBuzz.run();
                num++;
                notifyAll();
            } else
                wait();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (num <= n) {
            if (num % 3 == 0 && num % 5 == 0) {
                printFizzBuzz.run();
                num++;
                notifyAll();
            } else
                wait();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (num <= n) {
            if (num % 3 != 0 && num % 5 != 0) {
                printNumber.accept(num);
                num++;
                notifyAll();
            } else
                wait();
        }
    }
}