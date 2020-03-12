public class TwoPartSelection {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
        boolean isFlag=true;
        int number=3;

        int head=0;
        int end=arr.length-1;

        while (head<=end){
            int middle=(head+end)/2;
            if (arr[middle]==number){
                System.out.println("找到指定元素，索引为"+middle);
                isFlag=false;
                break;
            }else if (arr[middle]>number){
                end=middle-1;
            }else{
                head=middle+1;
            }
        }
        if (isFlag){
            System.out.println("未找到指定元素");
        }
    }
}
