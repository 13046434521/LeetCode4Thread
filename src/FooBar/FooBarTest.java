package FooBar;

/**
 * @author jtl
 * @date 2020/4/23 14:32
 * 两个不同的线程将会共用一个 FooBar.FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class FooBarTest {
    private static int n = 2;

    public static void main(String[] args) {
//        IFooBar iFooBar = new FooBar_1(n);
//        IFooBar iFooBar = new FooBar_2(n);
        IFooBar iFooBar = new FooBar_3(n);
        Runnable barRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.print("bar");
            }
        } ;

        Runnable fooRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        } ;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    iFooBar.bar(barRunnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    iFooBar.foo(fooRunnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}