package Foo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author jtl
 * @date 2020/5/11 11:40
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

class FooTest {
    public static void main(String[] args) {
        IFoo iFoo = new Foo_1();
        Runnable first = new Runnable() {
            @Override
            public void run() {
                System.out.print("1");
            }
        };
        Runnable second = new Runnable() {
            @Override
            public void run() {
                System.out.print("2");
            }
        };
        Runnable third = new Runnable() {
            @Override
            public void run() {
                System.out.print("3");
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    iFoo.first(first);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    iFoo.second(second);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    iFoo.third(third);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
