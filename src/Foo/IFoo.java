package Foo;

/**
 * @author jtl
 * @date 2020/5/11 11:39
 */

interface IFoo {
    void first(Runnable printFirst) throws InterruptedException;

    void second(Runnable printSecond) throws InterruptedException;

    void third(Runnable printThird) throws InterruptedException;
}
