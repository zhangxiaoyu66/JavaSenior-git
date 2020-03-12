package StreamTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest2 {
    @Test
    public void test01(){
        happyTime(400, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("花了"+integer);
            }
        });
        System.out.println("********");
        happyTime(400,(integer)->{
            System.out.println("花了"+integer);
        });
    }

    public void happyTime(Integer money, Consumer<Integer> con){
        con.accept(money);
    }

    @Test
    public void test02(){
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京");
        List<String> stringList = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(stringList);
        System.out.println("********");
        List<String> stringList1 = filterString(list, (s) -> {
            return s.contains("京");
        });
        System.out.println(stringList1);

    }

    //根据给定的规则，过滤集合中的字符串，此方法由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterString = new ArrayList<>();
        for (String s :list){
            if (pre.test(s)) {
                filterString.add(s);
            }
        }
        return filterString;
    }


}
