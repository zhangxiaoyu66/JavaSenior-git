package Reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

        @Test
        public void test01() throws Exception {

            Class<Person> aClass = Person.class;
            Person p = aClass.newInstance();
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(p,"Tom");
            System.out.println(name.get(p)) ;

        }
        @Test
        public void test02() throws Exception {
            Class<Person> aClass = Person.class;
            Person instance = aClass.newInstance();
            Method showNation = aClass.getDeclaredMethod("showNation", String.class,int.class);
            showNation.setAccessible(true);
            Object invoke = showNation.invoke(instance, "张小于",1);
            System.out.println(invoke);


        }
        @Test
    public void test03() throws Exception {
            Class<Person> personClass = Person.class;
            Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            Person zhangxiaoyu = constructor.newInstance("zhangxiaoyu");
            System.out.println(zhangxiaoyu);

        }


}
