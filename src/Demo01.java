import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        /*String str1="123";
        int num=Integer.parseInt(str1);
        System.out.println(num);
        int num1=123;

        String s = String.valueOf(num);
        System.out.println(s);//"123"

        String s1 = num + "";
        System.out.println(s1);//"123"

        System.out.println(str1==s1);
        System.out.println(num==num1);
        System.out.println(s==s1);
        System.out.println(str1==s);

       *//* Properties pro=new Properties();
        pro.load();
        *//*
        short s0=10;
        s0+=10;

        System.out.println("----------------------");
        String s2 = Integer.toBinaryString(60);
        String s3 = Integer.toHexString(60);
        System.out.println(s2);
        System.out.println(s3);

        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,3,2,4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);

        Arrays.fill(arr1,109);
        System.out.println(Arrays.toString(arr1));*/

        /*int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
        //TwoPartSelection01.binSeach(arr,2);
        TwoPartSelection01.binSeach(arr,0,arr.length,3);*/

        String s1 = "abc";//字面量的定义方式
        String s2=new String("abc");
        //String s2 = "abc";
        //s1 = "hello";

        System.out.println(s1 == s2);//比较s1和s2的地址值

        System.out.println(s1);
        System.out.println(s2);

        int maxValue = Integer.MAX_VALUE;

        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,3,2,4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);


    }
}
