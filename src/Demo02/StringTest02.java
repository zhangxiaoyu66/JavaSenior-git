package Demo02;

import org.junit.Test;

public class StringTest02 {

    @Test
    public void test1(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);
    }
}