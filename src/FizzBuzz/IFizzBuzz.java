package FizzBuzz;

import java.util.function.IntConsumer;

/**
 * @author jtl
 * @date 2020/5/11 15:54
 */

interface IFizzBuzz {
    // printFizz.run() outputs "fizz".
    void fizz(Runnable printFizz) throws InterruptedException;

    // printBuzz.run() outputs "buzz".
    void buzz(Runnable printBuzz) throws InterruptedException;

    // printFizzBuzz.run() outputs "fizzbuzz".
    void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException;

    // printNumber.accept(x) outputs "x", where x is an integer.
    void number(IntConsumer printNumber) throws InterruptedException;
}
