# include <iostream>
using namespace std;

int main() {
    int lines;
    cin >> lines;
    for (int i = 0; i < lines; i++) {
        int a, b, c;
        cin >> a >> b >> c;

        if (a <0 || b < 0 || c < 0) {
            cout << "None of these" << endl;
            continue;
        }

        if (a + b <= c || b + c <= a ||
            a + c <= b) {
            cout << "None of these" << endl;
            continue;
        } else if (a == b && b == c) {
            cout << "Equilateral" << endl;
        } else  if (a == b || b == c || a == c) {
            cout << "Isosceles" << endl;
        } else {
            cout << "None of these" << endl;
        }
    }
    return 0;
}
