package JavaNewTest;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {
    @Test
    public void test() {

        happyTime(400.0, (money) -> {
            System.out.println("123...." + money);
        });

        happyTime2(20, () -> {
            System.out.println("lalala");
            return 1;
        });

        happyTime3(10,(i)->{
            System.out.println("zzz");
            int i1 = i + 1;
            String s = String.valueOf(i1);
            System.out.println(s);
            return s;
        });

    }

    public void happyTime(Double money, Consumer<Double> consumer) {

        consumer.accept(money);
    }

    public Integer happyTime2(Integer i, Supplier<Integer> supplier) {

        Integer integer = supplier.get();
        int j = integer + i;
        return j;
    }

    public Integer happyTime3(Integer i, Function<Integer,String> function){
        String s = function.apply(i + 1);
        int parseInt = Integer.parseInt(s);
        return parseInt;
    }
}
