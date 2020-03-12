import Reflect.Person;
import org.junit.Test;

public class MyTest3 {

    @Test
    public void test01(){
        String str=null;
        System.out.println(str);
        StringBuffer sb=new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());

        System.out.println(sb);

        StringBuffer sb1=new StringBuffer(str);
        System.out.println(sb1);
    }

    @Test
    public void test02(){
        String property = System.getProperty("java.version");
        System.out.println(property);
    }
}
