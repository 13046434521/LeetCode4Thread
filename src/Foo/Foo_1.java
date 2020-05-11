package Foo;

import java.util.concurrent.Semaphore;

/**
 * @author jtl
 * @date 2020/4/23 13:48
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Foo_1 implements IFoo{
    private Semaphore mOne = new Semaphore(1);
    private Semaphore mTwo = new Semaphore(1);
    public Foo_1() {
        try {
            mOne.acquire();
            mTwo.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        mOne.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        mOne.acquire();
        printSecond.run();
        mOne.release();
        mTwo.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        mTwo.acquire();
        printThird.run();
    }
}
