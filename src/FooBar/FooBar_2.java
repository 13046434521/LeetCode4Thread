package FooBar;

/**
 * @author jtl
 * @date 2020/4/29 20:29
 */

class FooBar_2 implements IFooBar {
    private int n = 0;
    private volatile boolean isFoo = false;

    public FooBar_2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (isFoo) {
                continue;
            }
            printFoo.run();
            isFoo = true;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!isFoo) {
                continue;
            }
            printBar.run();
            isFoo = false;
        }
    }
}
