int findMatchingPair(const string& input) {
    int res = -1;
    vector<char> S;
    for (int i = 0; i < input.size(); i++) {
        if (!isalpha(input[i])) {
            break;
        }
        if (isupper(input[i])) {
            S.push_back(input[i]);
        } else {
            if (S.empty()) {
                break;
            } else {
                if (S.back() == toupper(input[i])) {
                    res = i;
                    S.pop_back();
                } else {
                    break;
                }
            }
        }
    }
    return res;
}
