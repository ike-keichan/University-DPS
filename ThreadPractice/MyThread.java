public class MyThread extends Thread {

    int num;

    MyThread (int num) { this.num = num; }

    void busywait (long howMany) { for (long index = 0; index < howMany; index++) ; }

    public void run () {
        while (true) {
            System.out.println ("Thread"+num);
            busywait (10000000); /* 􏰀􏰁􏰂􏰃 */
        }
    }

    public static void main (String[] args) {
        MyThread aThread1 = new MyThread (1);
        aThread1.start (); /* 􏰅􏰆􏰇􏰈􏰉􏰊􏰋􏰌􏰍􏰎􏰏􏰐􏰑run()􏰌􏰒􏰓*/
    }
}