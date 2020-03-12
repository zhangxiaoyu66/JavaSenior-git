/*
   对于静态字段，只有直接定义了该字段才会被初始化
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
        /*是对MyParent1的主动使用，但是没有主动使用MyChild1
        * 即所有的java虚拟机实现必须在每个类或接口被java程序“首次主动使用”时才初始化他们
        * */
    }
}
class MyParent1{
    public static String str="hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}
class MyChild1 extends MyParent1{
    //public static String str2="welcome";
    static{
        System.out.println("MyChild1 static block");
    }
}