package Demo01;

public class SingletonTest1 {
    private SingletonTest1(){
        System.out.println("实例化对象");
    }
    private static SingletonTest1 instance;
    public static SingletonTest1 getInstance(){
        if (instance==null) {

                if (instance==null){
                    System.out.println("lalalala");
                    instance= new SingletonTest1();

            }
        }
        return instance;
    }
}
class test3{
    public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            new Thread() {
                @Override
                public void run() {
                    SingletonTest1 instance = SingletonTest1.getInstance();

                }
            }.start();
        }
    }
}
