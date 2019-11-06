public class MyRunnable implements Runnable {

    int num;

    MyRunnable (int num) { this.num = num; }

    void busywait (long howMany) { for (long index = 0; index < howMany; index++) ; }

    public void run () {
        while (true) {
            System.out.println ("Thread"+num);
            busywait (10000000); /* 􏰀􏰁􏰂􏰃 */
        }
    }

    public static void main (String[] args) {
        Thread aThread1 = new Thread (new MyRunnable(1));
        aThread1.start (); /* 􏰅􏰆􏰇􏰈􏰉􏰊􏰋􏰌􏰍􏰎􏰏􏰐􏰑run()􏰌􏰒􏰓*/
    }
}