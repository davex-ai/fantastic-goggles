package Qwin;


import java.util.Arrays;

public class mj {
    public  int minVal(int[] arr) {
        int min = 0;
        for (int i : arr) {
            min = arr[0];
            if (i < min) {
                min = i;
                return min;
            }
        }
        return min;
    }

    public int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1 - i;j++ ){
                if(arr[j] > arr[j +1]){
                    arr[j] = arr[j+1];
                     arr[j+1] = arr[j];
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        mj test = new mj();
        int [] arr = {2, 11, 7, 15};

        System.out.println(test.minVal(arr));
        int mya = test.minVal(arr);


        System.out.println(mya);
        System.out.println(Arrays.toString(test.bubbleSort(arr)));

    }
}
