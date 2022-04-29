import java.util.*;
public class QuickSort{
    public static void quickSort(int[] arr, int l, int r){
        if (l >= r) return;
        int m = partition(arr, l, r);
        quickSort(arr, l, m-1);
        quickSort(arr, m+1, r);
    }


    public static int partition(int[] arr, int l, int r){
        int pviot = l;
        int value = arr[l];
        int index = l + 1;
        for (int i = index; i <= r; i++){
            if (arr[i] < value){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        index--;
        int temp = arr[pviot];
        arr[pviot] = arr[index];
        arr[index] = temp;
        return index;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}