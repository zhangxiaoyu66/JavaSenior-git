public class MyTest2 {
        public static void main(String[] args) {
            System.out.println(MyChild2.str2);
            /*是对MyChild1的主动使用,所以MyChild1会被初始化，并且初始化一个父类的子类时，父类也会被初始化
             *当一个类在初始化时，要求其父类全部都已经初始化
             * */
        }
    }

class MyParent2{
        public static String str="hello world";

        static {
            System.out.println("MyParent1 static block");
        }
    }
class MyChild2 extends MyParent2 {
    public static String str2="welcome";
    static {
        System.out.println("MyChild1 static block");
    }
}
