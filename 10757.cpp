#include <iostream>
#include <string>
using namespace std;

string s, s1;

int main()
{
	cin >> s >> s1;
	string result;
	int len = s.size();
	int len1 = s1.size();

	if (len > len1) {
		for (register int i = 0; i < len - len1; i++) {
			s1.insert(s1.begin(), '0');
		}
	}
	else {
		for (register int i = 0; i < len1 - len; i++) {
			s.insert(s.begin(), '0');
		}
		len = len1;
	}

	int before = 0, cur = 0;

	for (register int i = len-1; i >= 0; i--) {
		int num = s[i] - '0';
		int num1 = s1[i] - '0';

		cur = before;
		if (num + num1 + cur >= 10) {
			before = 1;
			result += (num + num1 + cur - 10) + '0';
		}
		else {
			before = 0;
			result += (num + num1 + cur) + '0';
		}
	}
	if (before == 1) result += '1';
	reverse(result.begin(), result.end());
	cout << result << "\n";
	return 0;
}