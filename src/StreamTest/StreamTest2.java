package StreamTest;

import StreamTest.lambdaData.Employee;
import StreamTest.lambdaData.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {

    //匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //allMatch(Predicate p) 检查是否匹配所有元素
        //练习：是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(employee -> {
            return employee.getAge() > 18;
        });
        System.out.println(allMatch);
        //anyMatch(Predicate p) 检查是否至少匹配一个元素
        boolean anyMatch = employees.stream().anyMatch(employee -> employee.getSalary() > 10000);
        System.out.println(anyMatch);
        //noneMatch(Predicate p) 检查是否没有匹配所有元素
        boolean noneMatch = employees.stream().noneMatch(employee -> employee.getName().startsWith("雷"));
        System.out.println(noneMatch);
        //findFirst() 返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);
        //findAny() 返回当前流中的任意元素
        Optional<Employee> employee1 = employees.parallelStream().findAny();
        System.out.println(employee1);

    }
    @Test
    public void test2(){
        //count() 返回流中元素总数
        List<Employee> employees = EmployeeData.getEmployees();
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
        System.out.println();
        //max(Comparator c) 返回流中最大值
        //返回最高的工资
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = salaryStream.max(Double::compareTo);
        System.out.println(max);
        System.out.println();
        //min(Comparator c) 返回流中最小值
        //返回最低工资的员工
        //forEach(Consumer c)
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);
        System.out.println();
        //内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
        employees.stream().forEach(System.out::println);
    }

    //归约
    @Test
    public void test3(){
        //reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
        //练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        //reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        //练习2：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce = salaryStream.reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce);
    }

    //收集
    @Test
    public void test4(){
        //collect(Collector c) 将流转换为其他形式。接收一个 Collector 接口的实现，用于给Stream中元素做汇总的方法
        //练习1：查询工资大于6000的员工，结果返回一个List或set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println();
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);

    }

}
