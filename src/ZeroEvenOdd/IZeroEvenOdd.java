package ZeroEvenOdd;

import java.util.function.IntConsumer;

/**
 * @author jtl
 * @date 2020/5/11 11:07
 */

interface IZeroEvenOdd {
    void zero(IntConsumer printNumber) throws InterruptedException;

    void even(IntConsumer printNumber) throws InterruptedException;

    void odd(IntConsumer printNumber) throws InterruptedException;
}
