package Demo01;

class Window1 implements Runnable{
    private static int ticket=20;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ",卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        //只创建了一个Runnable对象
        Window1 w = new Window1();
        Thread thread1 = new Thread(w);
        Thread thread2 = new Thread(w);
        Thread thread3 = new Thread(w);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
