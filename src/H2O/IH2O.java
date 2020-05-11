package H2O;

/**
 * @author jtl
 * @date 2020/5/11 13:22
 */

interface IH2O {
    void hydrogen(Runnable releaseHydrogen) throws InterruptedException ;

    void oxygen(Runnable releaseOxygen) throws InterruptedException ;
}
