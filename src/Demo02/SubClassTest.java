package Demo02;

public class SubClassTest {
    public static void main(String[] args) {
        SubClass s=new SubClass();
        //知识点1:接口中定义的静态方法，只能通过接口来调用
        AA.method1();
        //知识点2:通过实现类的对象，可以调用接口中的默认方法
        //如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
        s.method2();
        //如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，那么在实现类没重写此方法的情况下，报错。-->接口冲突。
        //这就需要我们必须在实现类中重写此方法
        s.method3();
    }
}
class SubClass extends SuperClass implements AA,CompareB{
    @Override
    public void method2(){
        System.out.println("SubClass,上海");
    }

    @Override
    public String method3() {
        return "";
    }

    //在子类(或实现类)的方法中调用父类、接口中被重写的方法
    public void myMethod(){
        //调用自己定义的重写的方法
        method3();
        //调用的是父类中的声明的方法
        super.method();
        //调用接口中的默认方法
        AA.super.method2();
        CompareB.super.method3();

    }
}