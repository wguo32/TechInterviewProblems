int findMinGates(vector<int> arrivals, vector<int> departures, int flights) {
    sort(arrivals.begin(), arrivals.end());
    sort(departures.begin(), departures.end());

    int res = 1, max = 1;
    int i = 1, j = 0;
    while (i < flights && j < flights) {
        if (arrivals[i] <= departures[j]) {
            res++;
            if (res > max) {
                max = res;
            }
            i++;
        } else {
            res--;
            j++;
        }
    }
    return max;
}
