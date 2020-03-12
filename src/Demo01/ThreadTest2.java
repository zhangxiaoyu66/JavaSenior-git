package Demo01;

public class ThreadTest2 implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class test1{
    public static void main(String[] args) {
        ThreadTest2 test2 = new ThreadTest2();

        Thread thread1 = new Thread(test2);
        Thread thread2 = new Thread(test2);
        thread1.setName("Thread1");
        thread2.setName("Thread2");
        // 通过Thread类的对象调用start():
        // 1.启动线程 2.调用当前线程的run()-->调用了Runnable类型的target的run()
        thread1.start();
        thread2.start();

    }
}