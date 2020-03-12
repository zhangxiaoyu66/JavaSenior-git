package Demo01;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author shkstart
 * @create 2019-02-15 下午 2:50
 */
public class BankTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }
}

class Singleton{

    private Singleton(){}

    private static Singleton instance = null;

    public static Singleton getInstance(){
        //方式一：效率稍差
//        synchronized (Singleton.class) {
//            if(instance == null){
//
//                instance = new Singleton();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if(instance == null){

            synchronized (Singleton.class) {
                if(instance == null){

                    instance = new Singleton();
                }

            }
        }
        return instance;
    }

}
