package ZeroEvenOdd;

/**
 * @author jtl
 * @date 2020/5/11 11:06
 */

class ZeroEvenOddTest {
    public static void main(String[] args) {
        IZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd1(5);

        Thread threadZero = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Zero");

        Thread threadEven = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Even");

        Thread threadOdd = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Odd");
        threadOdd.start();
        threadEven.start();
        threadZero.start();
    }
}
