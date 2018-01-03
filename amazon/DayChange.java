import java.util.Arrays;

public class DayChange {
    public int[] dayChange(int[] days, int n) {
        if (days == null || days.length <= 0) {
            return days;
        }
        int len = days.length;
        int[] change = new int[len + 2];
        for (int i = 0; i < len + 2; i++) {
            if (i == 0 || i == len + 1) {
                change[i] = 0;
            } else {
                change[i] = days[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            int pre = change[0];
            for (int j = 1; j < len + 1; j++) {
                int temp = change[j];
                change[j] = pre + change[j + 1];
                pre = temp;
            }
        }
        return Arrays.copyOfRange(change, 1, len + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int times = 5;
        DayChange dc = new DayChange();
        for(int num : dc.dayChange(arr, times)) {
            System.out.println(num);
        }
    }
}
