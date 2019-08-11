package list;

public class QuickSort {
    public static void main(String[] args){
        int[] input = {2,5,9,4,2,55,1,5,3,4,3};
        quickSort(input);
        for(int i = 0;i<input.length;i++){
            System.out.print(input[i]+" ");
        }
    }
    public static void quickSort(int[] list){
        if(list.length<=1)
            return;
        qSort(list,0,list.length-1);
    }
    public static void qSort(int[] list,int low,int high){
        int key = 0;
        if(low<high){
            key = partition(list,low,high);
            qSort(list,low,key-1);
            qSort(list,key+1,high);
        }
    }
    public static int partition(int[] list,int low,int high){
        int pivot = list[low];
        while(low<high){
            //快速排序是不稳定排序，比如low5------5-------high3，low和high交换后，原来的第一个5就会跑到第二个5的后面，并且由于相等时不交
            //换，所以可能之后两个5的顺序就这样了，所以不稳定排序。
            while(low<high&&list[high]>=pivot)
                high--;
            swap(list,low,high);
            while(low<high&&list[low]<=pivot)
                low++;
            swap(list,low,high);
        }
        return low;
    }
    public static void swap(int[] list,int low,int high){
        int temp = list[low];
        list[low] = list[high];
        list[high] = temp;
    }


}
