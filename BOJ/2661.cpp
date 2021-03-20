#include<iostream>
#include<string>
using namespace std;

int n;
bool finish;

bool ok(string s) {
	int len = s.length();
	int start = len - 1;

	for (int i = 1; i <= len / 2; i++) {
		string first = s.substr(start - i, i);
		string second = s.substr(start, i);
		if (first.compare(second) == 0) return false;
		--start;
	}
	return true;
}

void go(int len, string s) {
	if (finish) return;
	if (!ok(s)) return;
	if (len == n) {
		finish = true;
		cout << s << endl;
		return;
	}
	go(len + 1, s + "1");
	go(len + 1, s + "2");
	go(len + 1, s + "3");
}

int main() {
	scanf("%d", &n);
	go(1, "1");
	return 0;
}