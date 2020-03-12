public class TwoPartSelection01 {
    public static void binSeach(int arr[],int start,int end,int key){
        int middle=(start+end)/2;
            if (arr[middle]==key){
                System.out.println("查找的数字在"+middle);

            }else if(arr[middle]>key){
               binSeach(arr,0,middle-1,key);
            }else if(arr[middle]<key){
               binSeach(arr,middle+1,end,key);
            }
        }

    }
