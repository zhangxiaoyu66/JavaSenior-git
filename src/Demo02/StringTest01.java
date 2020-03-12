package Demo02;


/**
 * 一道面试题
 *
 * @author shkstart
 * @create 2019 上午 11:32
 */
public class StringTest01 {

    StringBuilder str = new StringBuilder("good");
    char[] ch = {'t', 'e', 's', 't'};
    int i = 2;

    public void change(StringBuilder str, char ch[], int i) {
        str.append("123");
        ch[0] = 'b';
        i = 10;
    }

    public static void main(String[] args) {
        StringTest01 ex = new StringTest01();
        ex.change(ex.str, ex.ch, ex.i);
        System.out.println(ex.str);
        System.out.println(ex.ch);
        System.out.println(ex.i);
    }
}

