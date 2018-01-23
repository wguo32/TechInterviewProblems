import java.util.Scanner;
import java.util.Arrays;

public class AirportGates {
    public static int findMinGates(int[] arrivals, int[] departures, int flights) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int count = 1, max = 1;
        int i = 1, j = 0;
        while (i < flights && j < flights) {
            if (arrivals[i] <= departures[j]) {
                count++;
                i++;
                if (count > max) {
                    max = count;
                }
            } else {
                count--;
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flights = in.nextInt();
        int[] arrivals = new int[flights];
        int[] departures = new int[flights];
        for (int i = 0; i < flights; i++) {
            arrivals[i] = in.nextInt();
        }
        for (int i = 0; i < flights; i++) {
            departures[i] = in.nextInt();
        }
        System.out.println(findMinGates(arrivals, departures, flights));
    }
}
