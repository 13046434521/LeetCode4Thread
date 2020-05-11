package FooBar;

/**
 * @author jtl
 * @date 2020/5/11 11:37
 */

interface IFooBar {
     void foo(Runnable printFoo) throws InterruptedException ;

     void bar(Runnable printBar) throws InterruptedException;
}
