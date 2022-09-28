package other.easy;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problem: 1114. Print in Order
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsprint-in-order
 */
class Foo {

    AtomicInteger i = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (i.get() != 1) ;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        i.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (i.get() != 2) ;
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        i.incrementAndGet();
    }
}