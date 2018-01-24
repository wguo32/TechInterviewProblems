/**
 * Created by shanfang on 12/19/17.
 */
public class SortArray {
    public static int[] reverseArray (int arr[]) {
//        int i, temp, originalLen = arr.length;
//        int len = originalLen;
//        for (i = 0; i < originalLen / 2; i++) {
//            temp = arr[i];
//            arr[i] = arr[len - 1];
//            arr[len - 1] = temp;
//            len -= 1;// this pointer moves from right to left
//        }
//        return arr;
        int i, temp, originalLen = arr.length;
        for (i = 0; i < originalLen / 2; i++) {
            temp = arr[i];
            arr[i] = arr[originalLen - 1 - i];
            arr[originalLen - 1- i] = temp;
        }
        return arr;
    }
    public static void main(String args[]) {
        int[] arr = {2,3,1,7,4,9,5};
        int[] newArr = reverseArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(newArr[i]);
        }
    }
}

