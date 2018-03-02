public class MergeSort {
    public void mergeSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }
        int low = 0, high = arr.length - 1;
        sort(arr, low, high);
    }

    private void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, high, mid);
    }
    public void merge(int[] arr, int low, int high, int mid) {
        // calculate length of the two subarrays to be merged
        int lenL = mid - low + 1;
        int lenR = high - mid;

        // create two temp arrays to hold value of subarrays
        int[] L = new int[lenL];
        int[] R = new int[lenR];
        for (int i = 0; i < lenL; i++) {
            L[i] = arr[low + i];
        }
        for(int i = 0; i < lenR; i++) {
            R[i] = arr[mid + 1 + i];
        }

        // the actual merge step, i and j are indexes for the two subarrays
        // k is the index in original array
        int i = 0, j = 0, k = low;
        while (i < lenL && j < lenR) {
            if (L[i] < R[j]) {
                arr[k] = L[i++];
            } else {
                arr[k] = R[j++];
            }
            k++;
        }
        while (i < lenL) {
            arr[k++] = L[i++];
        }
        while (j < lenR) {
            arr[k++] = R[j++];
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 35, 3, 12, 11, 13, 5, 6, 7};
        MergeSort ms = new MergeSort();
        ms.mergeSort(arr);
        System.out.println("After sorting:");
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
