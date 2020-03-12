package Demo01;

public class ThreadTest extends Thread {
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class test{
    public static void main(String[] args) {
        ThreadTest threadTest1 = new ThreadTest();
        ThreadTest threadTest2 = new ThreadTest();


        threadTest1.start();
        threadTest2.start();
    }
}