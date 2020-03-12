package StreamTest;

import StreamTest.lambdaData.Employee;
import StreamTest.lambdaData.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {
    //筛选与切片
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //filter(Predicate p) 接收 Lambda ，从流中排除某些元素
        Stream<Employee> stream = employees.stream();
        //查询员工表中薪资大于7000的员工信息
        stream.filter((e)->{return e.getSalary()>7000;}).forEach(System.out::println);
        System.out.println();
        //limit(long maxSize) 截断流，使其元素不超过给定数量
        //查询员工表中前三个数据
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println();
        //skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        employees.stream().skip(3).forEach(System.out::println);
        System.out.println();
        //distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.stream().distinct().forEach(System.out::println);
        System.out.println();
    }

    //映射
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        //map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        //将list中的所有数据大写
        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);
        //获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        //Employee::getName
        Stream<String> nameStream = employees.stream().map((employee) -> {
            return employee.getName();
        });
        nameStream.filter(name->name.length()>3).forEach(System.out::println);

        System.out.println();
        //列出所有的字符
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest1::fromStringToStream);
        streamStream.forEach(s->{s.forEach(System.out::println);});

        //flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        //列出所有的字符
        System.out.println();
        Stream<Character> characterStream = list.stream().flatMap(StreamTest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    //排序
    @Test
    public void test03(){
        //sorted() 产生一个新流，其中按自然顺序排序
        List<Integer> list = Arrays.asList(12, 43, 65, 24, 87, 0, -34, 5);
        list.stream().sorted().forEach(System.out::println);

        //抛出异常，原因是Employee没有实现Comparable接口
        //List<Employee> employees = EmployeeData.getEmployees();
        //employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)->{
            int ageValue=Integer.compare(e1.getAge(),e2.getAge());
            if (ageValue!=0) {
                return ageValue;
            }else {
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }
}
