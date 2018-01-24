/**
 * Created by shanfang on 12/19/17.
 */
public class ArrayOperation {
    public static int[] replaceValues(int arr[]) {
        int i, j, len = arr.length;
        if (len % 2 == 0) {
            for (i = 0; i < len; i++) {
                // originally it is i <= len,
                // it compiles but has run time error,
                //i.e., java.lang.ArrayIndexOutOfBoundsException
                arr[i] = 0;
            }
        } else {
            for (j = 0; j < len; j++) {
                arr[j] = 1;
            }
        }
        return arr;
    }
    public static void main(String args[]) {
        int[] arr = {1,2,3,4};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(replaceValues(arr)[i]);
        }
    }
}

