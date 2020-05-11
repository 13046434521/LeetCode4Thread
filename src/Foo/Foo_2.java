package Foo;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author jtl
 * @date 2020/4/23 14:13
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

class Foo_2 implements IFoo{
    private AtomicBoolean mAtomicOne = new AtomicBoolean(false);
    private AtomicBoolean mAtomicTwo = new AtomicBoolean(false);
    public Foo_2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        synchronized (mAtomicOne){
            mAtomicOne.notify();
            mAtomicOne.getAndSet(true);
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (mAtomicOne){
            while (!mAtomicOne.get()){
                mAtomicOne.wait();
            }
        }
        printSecond.run();
        synchronized (mAtomicTwo){
            mAtomicTwo.notify();
            mAtomicTwo.getAndSet(true);
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (mAtomicTwo){
            while (!mAtomicTwo.get()){
                mAtomicTwo.wait();
            }
        }
        printThird.run();
    }
}
