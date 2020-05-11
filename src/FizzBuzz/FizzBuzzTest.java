package FizzBuzz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jtl
 * @date 2020/5/11 15:55
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

class FizzBuzzTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        IFizzBuzz iFizzBuzz = new FizzBuzz_2(3);
        Runnable fizz = new Runnable() {
            @Override
            public void run() {
                System.out.print("fizz,");
            }
        };
        Runnable buzz = new Runnable() {
            @Override
            public void run() {
                System.out.print("buzz,");
            }
        };
        Runnable fizzbuzz = new Runnable() {
            @Override
            public void run() {
                System.out.print("fizzbuzz,");
            }
        };
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    iFizzBuzz.fizz(fizz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    iFizzBuzz.buzz(buzz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    iFizzBuzz.fizzbuzz(fizzbuzz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    iFizzBuzz.number(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
