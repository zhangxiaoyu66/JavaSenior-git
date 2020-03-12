package Demo01;

class Window2 extends Thread {
    private static int ticket = 20;
    @Override
    public void run() {
        while (true) {
            synchronized (Window2.class) {
                if (ticket > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ",卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();
        t1.start();
        t2.start();
        t3.start();
    }
}
