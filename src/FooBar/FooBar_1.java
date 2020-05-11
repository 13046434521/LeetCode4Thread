package FooBar;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author jtl
 * @date 2020/4/29 19:46
 */

class FooBar_1 implements IFooBar{
    private int n;
    private static AtomicBoolean mAtomicOne = new AtomicBoolean(false);
    private static AtomicBoolean mAtomicTwo = new AtomicBoolean(true);
    public FooBar_1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (!mAtomicTwo.get()){
                synchronized (mAtomicTwo){
                    try {
                        mAtomicTwo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            printFoo.run();
            mAtomicOne.getAndSet(true);
            mAtomicTwo.getAndSet(false);
            synchronized (mAtomicOne){
                mAtomicOne.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (!mAtomicOne.get()){
                synchronized (mAtomicOne){
                    try {
                        mAtomicOne.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            printBar.run();
            mAtomicTwo.getAndSet(true);
            mAtomicOne.getAndSet(false);
            synchronized (mAtomicTwo){
                mAtomicTwo.notifyAll();
            }
        }
    }
}
