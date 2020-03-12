package Demo02;

public interface AA {
    double PI = 3.14;
    //静态方法
    public static void method1() {
        System.out.println("hello lambda!");
    }
    //默认方法
    public default void method2() {
        System.out.println("北京");
    }
    default String method3() {
        return "上海";
    }
}