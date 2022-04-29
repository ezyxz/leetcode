import java.util.*;
/**
 * First Line the length of array
 * Second Line the array
 * Sample:
 * [input]:
 * 4
 * 7 6 5 4
 * [output]:
 * 4 5 6 7
 */
public class MergeSort{
    public static void mergeSort(int[] arr, int l, int r){
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1,r);
        merge(arr, l, m+1, r);
    }

    public static void merge(int[] arr, int l, int m, int r){
        int left_size = m - l;
        int right_size = r - m + 1;
        int[] left_arr = new int[left_size];
        int[] right_arr = new int[right_size];
        for (int i = l; i < m; i++){
            left_arr[i-l] = arr[i];
        }
        for (int i = m; i <= r; i++){
            right_arr[i-m] = arr[i];
        }
        int left_index = 0;
        int right_index = 0;
        int curr_index = l;
        while(right_index < right_size && left_index < left_size){
            arr[curr_index++] = left_arr[left_index] < right_arr[right_index] ? left_arr[left_index++] : right_arr[right_index++];
        }
        while(right_index < right_size){
            arr[curr_index++] = right_arr[right_index++];
        }
        while (left_index < left_size){
            arr[curr_index++] = left_arr[left_index++];
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}