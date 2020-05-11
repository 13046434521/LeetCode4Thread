package ZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author jtl
 * @date 2020/5/11 10:19
 */

class ZeroEvenOdd1 implements IZeroEvenOdd{
    private int n;
    private Semaphore mSemaphoreZero = new Semaphore(1);
    private Semaphore mSemaphoreEven = new Semaphore(0);
    private Semaphore mSemaphoreOdd = new Semaphore(0);
    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0;i<n;i++){
            mSemaphoreZero.acquire(1);
            printNumber.accept(0);
            if (i%2!=0){
                mSemaphoreEven.release();
            }else{
                mSemaphoreOdd.release();
            }
        }
    }
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2) {
            mSemaphoreOdd.acquire();
            printNumber.accept(i);
            mSemaphoreZero.release();
        }
    }
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2;i<=n;i+=2) {
            mSemaphoreEven.acquire();
            printNumber.accept(i);
            mSemaphoreZero.release();
        }
    }
}

