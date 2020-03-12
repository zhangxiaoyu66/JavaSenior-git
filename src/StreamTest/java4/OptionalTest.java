package StreamTest.java4;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    /*
    Optional.of(T t) : 创建一个 Optional 实例，t必须非空，否则报错
    Optional.empty() : 创建一个空的 Optional 实例
    Optional.ofNullable(T t)：t可以为null
    */
    @Test
    public void test1(){
        Girl girl = new Girl();
        //of(T t)：保证t是非空的
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl=null;
        //ofNullable(T t)；t可以是null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

        //orElse(T t1)：如果当前的optional内部封装的t是非空的，则返回内部的t，如果内部t是空的，则返回orElse()方法中的参数t1
        Girl girl1 = optionalGirl.orElse(new Girl("张小于"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }
    @Test
    public void test3(){
        //出现空指针问题
        Boy boy = new Boy();
        boy=null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化以后的方法
    public String getGirlName1(Boy boy){
        if (boy!=null) {
            Girl girl = boy.getGirl();
            if (girl!=null) {
                return girl.getName();
            }
        }
        return null;
    }

}
