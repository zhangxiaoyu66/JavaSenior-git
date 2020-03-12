package Demo01;

public class SingletonTest {
    private SingletonTest(){
        System.out.println("lalalala");
    }
    private static SingletonTest instance=new SingletonTest();

    public static SingletonTest getInstance(){
        return instance;
    }
}
class test2{
    public static void main(String[] args) {
        SingletonTest instance = SingletonTest.getInstance();
        System.out.println(instance);
    }
}