package FizzBuzz;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author jtl
 * @date 2020/5/11 15:54
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * <p>
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 假设有这么一个类：
 * class FizzBuzz {
 *  public FizzBuzz(int n) { ... }               // constructor
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class FizzBuzz_2 implements IFizzBuzz {
    private final int n;
    private final AtomicInteger mAtomicInteger = new AtomicInteger(1);

    public FizzBuzz_2(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            synchronized (FizzBuzz_2.class) {
                if (mAtomicInteger.get() > n) {
                    break;
                }
                if (mAtomicInteger.get() % 3 == 0 && mAtomicInteger.get() % 5 != 0) {
                    printFizz.run();
                    mAtomicInteger.incrementAndGet();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            synchronized (FizzBuzz_2.class) {
                if (mAtomicInteger.get() > n) {
                    break;
                }
                if (mAtomicInteger.get() % 5 == 0 && mAtomicInteger.get() % 3 != 0) {
                    printBuzz.run();
                    mAtomicInteger.incrementAndGet();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            synchronized (FizzBuzz_2.class) {
                if (mAtomicInteger.get() > n) {
                    break;
                }
                if (mAtomicInteger.get() % 5 == 0 && mAtomicInteger.get() % 3 == 0) {
                    printFizzBuzz.run();
                    mAtomicInteger.incrementAndGet();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (FizzBuzz_2.class) {
                if (mAtomicInteger.get() > n) {
                    break;
                }
                if (mAtomicInteger.get() % 5 != 0 && mAtomicInteger.get() % 3 != 0) {
                    printNumber.accept(mAtomicInteger.get());
                    System.out.print(",");
                    mAtomicInteger.incrementAndGet();
                }
            }
        }
    }
}
