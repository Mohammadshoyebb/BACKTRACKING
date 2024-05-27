public class BacktrackingExample{
    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArr(arr,0,1);
        printArr(arr);
    }
    public static void changeArr(int arr[],int index,int val){
        //Base case
        if(index == arr.length){
            printArr(arr);
            return;
        }
        //logic
        arr[index] = val;
        changeArr(arr, index+1, val+1);
        //BackTrack
        arr[index] -= 2;
    }
    public static void printArr(int arr[]){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}