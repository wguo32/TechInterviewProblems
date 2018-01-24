/**
 * Created by shanfang on 12/19/17.
 */
import java.util.Arrays;

public class ShortArray {
    // int[] arr is preferable, int arr[] is for C programmers to get used to java
    public static int[] removeElement(int[] arr, int index) {
        int i, j, len = arr.length;
        if (index < len) {
            for (i = index; i < len - 1; i++) {
                arr[i] = arr[i + 1];
            }
            int[] rarr = new int[len - 1];
            for(i = 0; i < len - 1; i++) {
                rarr[i] = arr[i];
            }
            return rarr;
        } else {
            return arr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,4,2,6};
        System.out.println(Arrays.toString(removeElement(arr, 3)));
    }
}

