package Demo01;

public class ThreadTestDemo {
    public static void main(String[] args) {
/*
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    if (i%2!=0) {
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }

            }
        }).start();
*/
        MyThread myThread = new MyThread();
        Thread t=new Thread(myThread);
        t.start();
        Thread.currentThread().setName("主线程");

        for (int i=0;i<100;i++){
            if (i%2!=0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            if (i==31) {

                try {
                    t.join();   //当前main线程暂停1000ms
                } catch (InterruptedException e) {
                }
            }
        }

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    if (i%2!=0) {
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }).start();*/
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i % 20 == 0) {
                Thread.yield();
            }

        }
    }
}
