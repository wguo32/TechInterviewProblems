// I referenced online source for this cpp code, correctness is not guaranteed
char findFirstRepeatingChar(string s) {
    vector<int> record(128, 0);
    for (int i = 0; i < s.size(); i++) {
        record[(int)s[i]]++;
    }

    for (int i = 0; i <s.size(); i++) {
        if (record[(int)s[i]] > 1) {
            return s[i];
        }
    }
    return '';
}
