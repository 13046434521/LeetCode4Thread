package FooBar;

import java.util.concurrent.Semaphore;

/**
 * @author jtl
 * @date 2020/4/29 20:29
 */

class FooBar_3 implements IFooBar{
    private int n = 0;
    private static Semaphore foo = new Semaphore(1);
    private static Semaphore bar = new Semaphore(0);

    public FooBar_3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}
