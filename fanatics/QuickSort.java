public class QuickSort {
    public void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(arr, low, high);
        sort(arr, low, p - 1);
        sort(arr, p + 1, high);
    }
    public int partition(int[] arr, int low, int high) {
        int i = low - 1;
        int pivot = arr[high];
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, high);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]) {
        int[] arr = {3,1,8,10,2,17,39};
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("After quick sort:");
        QuickSort qs = new QuickSort();
        qs.quickSort(arr);
        for(int num : arr) {
            System.out.println(num);
        }
    }
}
