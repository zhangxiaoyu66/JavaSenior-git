package DataStructures;

public class Main {
    public static void main(String[] args) {
        Array arr=new Array(20);
        for(int i=0;i<10;i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        /*System.out.println(String.format("%s, world", "Hello"));     // 输出 "     Hello, world"
        System.out.println(String.format("%8d", 123));                 // 输出 "     123"*/
    }
}
