package H2O;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jtl
 * @date 2020/4/30 17:45
 */

class H2OTest {
    private static String H2O = "HOHHHOHHHHHHHHOOOO";

    public static void main(String[] args) {
        IH2O IH2O = new H2O_2();
        Runnable runnableH = new Runnable() {
            @Override
            public void run() {
                System.out.print("H");
            }
        };
        Runnable runnableO = new Runnable() {
            @Override
            public void run() {
                System.out.print("O");
            }
        };
        ExecutorService executors = Executors.newFixedThreadPool(H2O.length());

        for (int i = 0; i < H2O.length(); i++) {
            String data = String.valueOf(H2O.charAt(i));
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (data.equals("H")) {
                            IH2O.hydrogen(runnableH);
                        } else if (data.equals("O")) {
                            IH2O.oxygen(runnableO);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
